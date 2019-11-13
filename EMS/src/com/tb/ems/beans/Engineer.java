package com.tb.ems.beans;

public class Engineer extends Employee {
	private double total_salary;
	
	@Override
	public void setbasesalary(double basesalary) {
		super.setbasesalary(basesalary);
		double allowance =basesalary/20;
		total_salary=basesalary+allowance;
	}
	@Override
	public double getbasesalary() {
		// TODO Auto-generated method stub
		return this.total_salary;
	}
}
