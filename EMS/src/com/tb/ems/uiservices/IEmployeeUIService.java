package com.tb.ems.uiservices;

import java.util.List;

import com.tb.ems.beans.Employee;

/**
 * IEmployeeUIService is an interface which defines various abstract functions
 * for the UIService layer.
 */
public interface IEmployeeUIService
{
	public void AddNewManager();
	public void AddNewEngineer();
	public void removeEmployee();
	public void showAllEmployee();
	public List<Employee> searchEmployeeByName(String name);
	public void sortEmployee();
}
