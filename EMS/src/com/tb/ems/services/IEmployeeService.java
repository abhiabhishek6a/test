package com.tb.ems.services;

import java.util.List;

import com.tb.ems.beans.Employee;
import com.tb.ems.beans.Engineer;
import com.tb.ems.beans.Manager;
import com.tb.ems.services.exception.EmployeeServiceException;
/**
 * IEmployeeService is an interface which defines various abstract functions
 * for the service layer.
 */
public interface IEmployeeService
{
	public void addNewManager(Manager manager);
	public void addNewEngineer(Engineer engineer);
	public void removeEmployeeByName(List<Employee> employeelist);
	public List<Employee> showAllEmployeeInformation() throws EmployeeServiceException;
}
