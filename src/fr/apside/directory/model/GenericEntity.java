package fr.apside.directory.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class GenericEntity implements Serializable, IEntity {
	@Transient
	public static final long serialVersionUID = 196919661993L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/* (non-Javadoc)
	 * @see fr.apside.directory.model.IEntity#getId()
	 */
	public long getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.apside.directory.model.IEntity#setId(long)
	 */
	public void setId(long id) {
		this.id = id;
	}
}
