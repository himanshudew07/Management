package com.himanshu.org.exception;

public class DataNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		super("Data not found exception");
	}

}
