package fr.apside.directory.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import fr.apside.directory.model.Employee;
import fr.apside.directory.services.EmployeeService;
import fr.apside.directory.services.ServiceLocator;

@Path("/employees")
@Consumes("application/json")
@Produces("application/json")
public class EmployeeResource {

	@GET
	public Collection<Employee> getAllEmployees() {
		return getService().getAll();
	}

	@POST
	public Employee saveEmployee(Employee employee) {
		if (employee != null && employee.getId() == null) {
			employee = getService().create(employee);
		} else {
			getService().update(employee);
		}
		return employee;
	}

	@PUT
	@Path("/{employeeId}")
	public void updateEmployee(Employee employee) {
		getService().update(employee);
	}
	@POST
	@Path("/{employeeId}/update")
	public void updateEmployee4Flex(Employee employee) {
		updateEmployee(employee);
	}
	
	@DELETE
	@Path("/{employeeId}")
	public void deleteEmployee(@PathParam("employeeId") String id) {
		if (id != null) {
			getService().deleteById(new Long(id));
		}
	}
	@POST
	@Path("/{employeeId}/delete")
	public void deleteEmployee4Flex(@PathParam("employeeId") String id) {
		deleteEmployee(id);
	}
	
	@GET
	@Path("/{employeeId}")
	public Employee getEmployee(@PathParam("employeeId") String id) {
		return getService().read(new Long(id));
	}

	private EmployeeService getService() {
		return ServiceLocator.getEmployeeService();
	}
}
