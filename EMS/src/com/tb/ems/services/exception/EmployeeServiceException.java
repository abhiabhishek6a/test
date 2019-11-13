package com.tb.ems.services.exception;

public class EmployeeServiceException extends Exception {

	public static final String NO_EMPLOYEE_FOUND="no employee found in list";
	
	public EmployeeServiceException(String msg)
	{
		super(msg);
	}
}
