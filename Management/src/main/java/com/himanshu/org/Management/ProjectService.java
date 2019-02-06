package com.himanshu.org.Management;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.himanshu.org.Management.model.Employee;
import com.himanshu.org.Management.model.Project;

@Path("/")
public class ProjectService {
	
	public static HashMap<Integer,Project> projects = new HashMap<>();
	static {
		projects.put(1, new Project(1,"ATM Switch","This project is for Applo client"));
		projects.put(2, new Project(2,"POS","This is developed in android"));
		projects.put(3, new Project(3,"OPE","Trading application"));
	}
	
@GET
@Produces(MediaType.APPLICATION_JSON)
public String test() {
	return "test called";
}


@GET
@Path("/{projectid}")
@Produces(value = {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public Response getProject(@PathParam("id") int id,@PathParam("projectid") int pid,@Context UriInfo uriinfo) throws URISyntaxException {
	Project project = projects.get(id);
	URI uri = uriinfo.getAbsolutePathBuilder().path("test").build();
	System.out.println("URI INFO : "+uriinfo.getAbsolutePath());
	return Response.created(new URI("http://localhost:8080/Management/webapi/employees/2/projects/"+project.getProjectID()))
		   .entity(project)
		   .build();
}

}
