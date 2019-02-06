package com.himanshu.org.Management;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.himanshu.org.Management.model.ErrorMessage;
import com.himanshu.org.exception.DataNotFoundException;

@Path("/exception")
public class ExceptionDemo {

	@GET
	@Path("/{id}")
	public String throwException(@PathParam("id") int id) throws Exception {
		if(id == 1) 
			return "return value OK";
		if(id == 2) {
		
			ErrorMessage errorMessage = new ErrorMessage("this is WabApplicationException",200,"org.himanshu.Error");
			Response res =   Response.status(Status.OK)
					.entity(errorMessage)
					.build();
			throw new WebApplicationException(res);
		}
		else
			throw new DataNotFoundException();
		
		
				
		
	}
}
