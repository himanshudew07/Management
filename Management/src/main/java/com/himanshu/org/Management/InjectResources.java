package com.himanshu.org.Management;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inject")
public class InjectResources {
	
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	@Path("annotations")
	public String getInject(@MatrixParam("value") String value,@HeaderParam("IP") String ip,
			@CookieParam("JSESSIONID") String cookie) {
		
		return "Return value : "+value+" IP : "+ip+" Cookie : "+cookie;
	}

}
