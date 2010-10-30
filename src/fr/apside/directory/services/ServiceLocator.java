package fr.apside.directory.services;


public class ServiceLocator {
	private static final EmployeeService EMPLOYEE_SERVICE = 
        new EmployeeService(); 
 
    private ServiceLocator() {} 
 
    public static EmployeeService getEmployeeService() { 
        return EMPLOYEE_SERVICE; 
    } 
}
