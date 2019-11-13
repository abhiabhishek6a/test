package com.tb.ems.beans;

import java.util.Date;

public abstract class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String designation;
	private String contactNumber;
	private double basesalary;
	private Date dateOfBirth;
	private Date dateOfJoining;
	static int current_id=1;
	public Employee()
	{
		employeeId=current_id++;
	}
	public int getemployeeId() {
		return employeeId;
	}
	public void setemployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designation) {
		this.designation = designation;
	}
	public String getcontactNumber() {
		return contactNumber;
	}
	public void setcontactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public double getbasesalary() {
		return basesalary;
	}
	public void setbasesalary(double basesalary) {
		this.basesalary = basesalary;
	}
	public Date getdateOfBirth() {
		return dateOfBirth;
	}
	public void setdateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getdateOfJoining() {
		return dateOfJoining;
	}
	public void setdateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public static int getCurrent_id() {
		return current_id;
	}
	public static void setCurrent_id(int current_id) {
		Employee.current_id = current_id;
	}
		
}
