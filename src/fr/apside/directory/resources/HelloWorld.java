package fr.apside.directory.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorld {
	@GET
	@Produces("text/plain")
	public String hello(){
		return "Hello world";
	}
}
