package fr.apside.directory.services;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import fr.apside.directory.dao.EMF;
import fr.apside.directory.model.IEntity;
import fr.apside.directory.resources.EmployeeResource;

public class GenericService <T extends IEntity> {

		private transient final Class<T> entityClass;
		private transient final static Logger logger = Logger.getLogger(EmployeeResource.class.getCanonicalName());

		@SuppressWarnings("unchecked")
		public GenericService() {
			entityClass = (Class) ((java.lang.reflect.ParameterizedType) this
					.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}

		protected transient EntityManager manager = EMF.get().createEntityManager();

		public T create(final T entity) throws EntityExistsException,
				IllegalStateException, IllegalArgumentException,
				TransactionRequiredException {
			logger.log(Level.FINER, "Create entity: " + entity);
			EntityTransaction transaction = manager.getTransaction();
			try{
				transaction.begin();
				manager.persist(entity);
				manager.flush();
				transaction.commit();
			}finally{
				if(transaction.isActive()){
					transaction.rollback();
				}
			}
			return entity;
		}

		public T read(final Serializable primaryKey) throws IllegalStateException,
				IllegalArgumentException {
			logger.log(Level.FINER, "Read entity by id: " + primaryKey);
			return manager.find(entityClass, primaryKey);
		}

		public void update(final T entity) throws IllegalStateException,
				IllegalArgumentException, TransactionRequiredException {
			logger.log(Level.FINER, "Update entity: " + entity);
			manager.merge(entity);
			//manager.flush();
		}

		public void delete(final T entity) throws IllegalStateException,
				IllegalArgumentException, TransactionRequiredException,
				PersistenceException {
			logger.log(Level.FINER, "Delete entity: " + entity);
			manager.remove(entity);
			//manager.flush();
		}
		public void deleteById(Serializable id) {
			logger.log(Level.FINER, "Read entity by id: " + id);
			delete(read(id));
		}

}
