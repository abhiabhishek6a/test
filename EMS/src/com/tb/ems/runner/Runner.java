package com.tb.ems.runner;

import java.util.ArrayList;
import java.util.List;

import com.tb.ems.beans.Engineer;
import com.tb.ems.beans.Manager;
import com.tb.ems.beans.Employee;

import com.tb.ems.uiservices.EmployeeUIServiceImpl;
import com.tb.ems.uiservices.IEmployeeUIService;
import com.tb.ems.utils.ReadUtil;

public class Runner
{

	private ReadUtil m_readUtil;
	private IEmployeeUIService m_EmployeeUIService;

	/**
	 * This is a default constructor of the class
	 */
	public Runner()
	{
		m_readUtil = new ReadUtil();
		m_EmployeeUIService = new EmployeeUIServiceImpl();
		checkUserOptions();
	}

	/**
	 * This function takes the user choice as the menu is displayed and call the
	 * functions accordingly.
	 *
	 */
	private void checkUserOptions()
	{
		int choice = 0;
		List<Employee> employeelist = new ArrayList<Employee>();
		do
		{
			displayMainMenu();
			choice = m_readUtil.readInt("Input Your choice", "Input valid Choice");
			switch (choice)
			{
			case 1:
				m_EmployeeUIService.AddNewManager();
				break;
			case 2:
				m_EmployeeUIService.AddNewEngineer();
				break;
			case 3:
				m_EmployeeUIService.removeEmployee();
				break;

			case 4:
				m_EmployeeUIService.showAllEmployee();
				break;

			case 5:
				String name = m_readUtil.readString("Input Employee Name(or any part of name)",
						"String cannot be empty");
				try
				{
					employeelist = m_EmployeeUIService.searchEmployeeByName(name);
					System.out.println();
				} catch (NullPointerException e)
				{
					System.out.println("Emloyee not found");
				}
				break;

			case 6:
				m_EmployeeUIService.sortEmployee();
				break;

			case 7:
				System.out.println(" Thanks For using this system ");
				break;
			default:
				System.out.println("wrong choice");
				break;
			}
		} while (choice < 6);
	}

	/**
	 * This fuction displays the main menu of the system.
	 *
	 */
	private void displayMainMenu()
	{
		System.out.println("     Main Menu     ");
		System.out.println("-------------------");
		System.out.println("1. Add New Manager ");
		System.out.println("2. Add New Engineer ");
		System.out.println("3. Remove An Employee ");
		System.out.println("4. Show All Employees Information ");
		System.out.println("5. Search An Employee ");
		System.out.println("6. Sort By First Name ");
		System.out.println("7. Exit ");
	}

	/**
	 * This is the main fuction which runs the default constructor of the class.
	 */
	public static void main(String[] args)
	{
		new Runner();
	}
}
