package fr.apside.directory.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import fr.apside.directory.model.Employee;
import fr.apside.directory.utils.Constants;

@Path("/login")
@Consumes("application/json")
@Produces("application/json")
public class LoginService {
	@POST
	public Employee login(Employee user, @Context HttpServletRequest request) {
		if (user.getName().equalsIgnoreCase("user1")
				&& user.getPassword().equals("password1")) {
			user.setId(1001l);
			user.setEmail("fake@email.com");
			// set user session to check if user login or not.
			request.getSession().setAttribute(Constants.SESSION_USER, user);
			return user;
		}
		return null;
	}
}
