package com.himanshu.org.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.himanshu.org.Management.model.ErrorMessage;

@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		System.out.println("DataNotFoundMapper.toResponse is called");
	//	ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),410,"org.himanshu.Error");
		return  Response.status(Status.OK)
				.entity("DataNotFoundMapper.toResponse is called")
				.build();
	}

}
