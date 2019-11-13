package com.tb.ems.beans;

public class Manager extends Employee {
	
	private double total_salary;
	
	@Override
	public void setbasesalary(double basesalary) {
		super.setbasesalary(basesalary);
		double allowance =basesalary/10;
		total_salary=basesalary+allowance;
	}
	@Override
	public double getbasesalary() {
		// TODO Auto-generated method stub
		return this.total_salary;
	}
}
