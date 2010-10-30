package fr.apside.directory.services;

import java.util.Collection;

import fr.apside.directory.model.Employee;

public class EmployeeService extends GenericService<Employee>{

	@SuppressWarnings("unchecked")
	public Collection<Employee> getAll() {
		return manager.createQuery("select from " + Employee.class.getName())
				.getResultList();
	}

	
}
