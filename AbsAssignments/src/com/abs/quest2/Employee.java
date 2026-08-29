package com.abs.quest2;

public abstract class Employee {
	 String empName;
	 double empSalary;
	 int empId;
	 final String COMPANYNAME="Infosys";
	
	public Employee(String empName, double empSalary, int empId) {
		this.empName = empName;
		this.empSalary = empSalary;
		this.empId = empId;
		
	}
	
	public void printDetails() {
		System.out.println("Employee Name:: "+empName);
		System.out.println("Employee Salary:: "+empSalary);
		System.out.println("Employee ID:: "+empId);
		System.out.println("Employee Company Name:: "+COMPANYNAME);
		
	}
	abstract void calcBonus(double amount);
	abstract void showProjects();
	
	public String[] showCourses() {
		return new String[] {"Java","JavaScript","Servlets","JSP"};
		}
	
	private void officeHours() {
		System.out.println(" 14 hours for day:: ");
	}
	final void showRules() {
		officeHours();
		System.out.println("Leave policies::");
		System.out.println("OD Policies");
	}
	
	

}
