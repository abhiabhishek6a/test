package com.tb.ems.uiservices;

import java.util.*;

import com.tb.ems.beans.Employee;
import com.tb.ems.beans.Engineer;
import com.tb.ems.beans.Manager;
import com.tb.ems.services.EmployeeServiceImpl;
import com.tb.ems.services.IEmployeeService;
import com.tb.ems.services.exception.EmployeeServiceException;
import com.tb.ems.utils.ReadUtil;


/**
 *This is an EmployeeUIServiceImpl class which implements the IEmployeeUIService
 *interface and defines all the abstract method of the interface.
 */
public class EmployeeUIServiceImpl implements IEmployeeUIService
{
	private ReadUtil m_readUtil;

	private IEmployeeService m_employeeService;

	/**
	 *This is the default constructor of the class which creates objects of
	 *all the instance variables of the class.
	 */
	public EmployeeUIServiceImpl()
	{
		m_readUtil= new ReadUtil();
		m_employeeService=new EmployeeServiceImpl();
	}
	/**
	 *This function read a manager detail and add that manager to the list.
	 */
	public void AddNewManager()
	{
		Manager manager=new Manager();
		manager.setfirstName(m_readUtil.readString("Input Your First name","String cannot be empty"));
		manager.setlastName(m_readUtil.readString("Input your Last name","Sring cannot be empty"));
		manager.setdesignation(m_readUtil.readString("Input Designation","String cannot be empty"));
		manager.setcontactNumber(m_readUtil.readString("Input Contact number","Input correct values"));
		manager.setbasesalary(m_readUtil.readDouble("Input Your Base Salary","Input Correct Values"));
		manager.setdateOfBirth(m_readUtil.readDate("Input Date of Birth (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		manager.setdateOfBirth(m_readUtil.readDate("Input Date Of Joining (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		m_employeeService.addNewManager(manager);
	}
	/**
	 *This function read an engineer detail and add that engineer to the list.
	 */
	public void AddNewEngineer()
	{
		Engineer engineer=new Engineer();
		engineer.setfirstName(m_readUtil.readString("Input Your First name","String cannot be empty"));
		engineer.setlastName(m_readUtil.readString("Input your Last name","Sring cannot be empty"));
		engineer.setdesignation(m_readUtil.readString("Input Designation","String cannot be empty"));
		engineer.setcontactNumber(m_readUtil.readString("Input Contact number","Input correct values"));
		engineer.setbasesalary(m_readUtil.readDouble("Input Your Base Salary","Input Correct Values"));
		engineer.setdateOfBirth(m_readUtil.readDate("Input Date of Birth (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		engineer.setdateOfBirth(m_readUtil.readDate("Input Date Of Joining (DD-MM-YYYY)","enter valid date format(DD-MM-YYYY)"));
		m_employeeService.addNewEngineer(engineer);
	}
	/**
	 * This function remove an manager if the list contains that manager.
	 * It reads the manager name from the user and search for it in the list then
	 * make a call for removing that manager.
	 * @exception EmployeeServiceException This exception is thrown when user
	 * want to see the manager detail and the list is empty.
	 */
	public void removeEmployee(){
		List<Employee> managerlist1;

		try{
			List<Employee> managerlist=m_employeeService.showAllEmployeeInformation();
			managerlist1=new ArrayList<Employee>();
			String name = m_readUtil.readString("Enter Employee name(or any part of name) : ","String cannot be empty");
			managerlist1=searchEmployeeByName(name);
			m_employeeService.removeEmployeeByName(managerlist1);

		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}catch(NullPointerException e){
			System.out.println("Emloyee not found with this name");
		}
	}
	/**
	 * This function shows the information of all the manager containing in the list.
	 * @exception EmployeeServiceException thrown when user want to see the manager
	 * detail and the list is empty.
	 */
	public void showAllEmployee()
	{
		try
		{
			List<Employee> managerlist=m_employeeService.showAllEmployeeInformation();
			System.out.println("All Employees Information : \n ");
			printList(managerlist);

		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This function search an manager in the list by its name.
	 * @param Name. It can be first name,last name or full name of the manager
	 * @return List. Returns the list of manager having the name from which search is initiated.
	 * @exception EmployeeServiceException This exception is thrown when user
	 * want to see the manager detail and the list is empty.
	 * @exception StringIndexOutOfBoundException Thrown by String methods to
	 * indicate that an index is either negative or greater than the size of the
	 * string.
	 * @exception NullPointerException Thrown when an application
	 * attempts to use null in a case where an object is required.
	 */
	 public List<Employee> searchEmployeeByName(String name) throws NullPointerException {
		List<Employee> managerlist1 = null;
		try {
			name = name.toLowerCase();
			List<Employee> managerlist=m_employeeService.showAllEmployeeInformation();
			managerlist1 = new ArrayList<Employee>();
			Iterator<Employee> managerlistiterator= managerlist.iterator();
			while(managerlistiterator.hasNext()) {
				Employee manager=managerlistiterator.next();
				String fullName = (manager.getfirstName()+" "+manager.getfirstName()).toLowerCase();
				if(fullName.contains(name))	{
					managerlist1.add(manager);
				}
			}
			printList(managerlist1);
		}catch(EmployeeServiceException e){
			System.out.println(e.getMessage());
		}
		if((managerlist1==null) || (managerlist1.size()==0))
			throw new NullPointerException();

		return managerlist1;
	}
	 /**
	  * This function sorts the complete list according to first name. It uses the
	  * another class which implements the comparator interface and
	  * its function compareTo().
	  * @exception EmployeeServiceException exception is thrown when user want to
	  * see the manager detail and the list is empty.
	  * @exception ClassCastException Thrown to indicate that the code has attempted
	  * to cast an object to a subclass of which it is not an instance.
	  * @exception UnsupportedOperationException Thrown to indicate that the requested
	  * operation is not supported.
	  */
	public void sortEmployee()
	{
		List<Employee> managerlist1=null;
		try
		 {
			List<Employee> managerlist=m_employeeService.showAllEmployeeInformation();
			managerlist1.addAll(managerlist);

			System.out.println(" Before Sorting ");
			System.out.println("---------------------");
			printList(managerlist);

			System.out.println(" After sorting ");
			System.out.println("---------------------");
			Collections.sort(managerlist1,new FirstNameCompare());
			printList(managerlist1);

		 }catch (EmployeeServiceException e){
			System.out.println(e.getMessage());
		 }catch(ClassCastException e){
			System.out.println(e.getMessage());
		 }catch(UnsupportedOperationException e){
			System.out.println(e.getMessage());
		 }
	 }

	/**
	 * This function prints the details of an Employee.
	 * @param manager Parameter of the manager bean.
	 */
	private void printInfo(Employee manager)
	{
		System.out.println("---------------------------------------");
		System.out.println("Employee ID  "+manager.getemployeeId());
		System.out.println("First Name : "+manager.getfirstName());
		System.out.println("Last Name : "+manager.getlastName());
		System.out.println("Designation :"+manager.getdesignation());
		System.out.println("Total Salary : "+manager.getbasesalary());
		System.out.println("Date Of Birth : "+manager.getdateOfBirth());
		System.out.println("Date of Joining : "+manager.getdateOfBirth());
		System.out.println("-----------------------------------------");
		System.out.println();
	}
	/**
	 * This function prints the details of all Employee which are in the list.
	 * @param managerlist Parameter of the List(Employee bean).
	 */
	private void printList(List<Employee> managerlist)
	{
		Iterator<Employee> managerlistiterator=managerlist.iterator();
		while(managerlistiterator.hasNext())
		{
			Employee manager=managerlistiterator.next();
			System.out.println("---------------------------------------");
			System.out.println("Employee ID : "+manager.getemployeeId());
			System.out.println("First Name : "+manager.getfirstName());
			System.out.println("Last Name : "+manager.getlastName());
			System.out.println("Designation : "+manager.getdesignation());
			System.out.println("Contact Number : "+manager.getcontactNumber());
			System.out.println("Total Salary : "+manager.getbasesalary());
			System.out.println("Date Of Birth : "+manager.getdateOfBirth());
			System.out.println("Date Of Joining : "+manager.getdateOfBirth());
			System.out.println("-----------------------------------------");
			System.out.println();
		}
	}
}