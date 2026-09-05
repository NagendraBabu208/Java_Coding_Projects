package com.abstraction.model;

public abstract class Employee {

	static final String COMPANYNAME="Infosys";
	String employeeName;
	int employeeId;
	String employeeType;
	public Employee(String employeeName, int employeeId, String employeeType) {
		
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeType=employeeType;
	}
	
	void printDetails() {
		System.out.println("Employee Name::- "+employeeName);
		System.out.println("Employee Id::-"+employeeId);
		System.out.println("Employee Type::- "+employeeType);
		System.out.println(" Employee Company Name::-"+COMPANYNAME);
		
	}
	
	abstract void calcBonus(int amount);
	static void projectDetails() {
		System.out.println("Developed project using java!!!");
		}
	
	final void salaryProcess() {
		double employeeSalary=20000;
		double calculateSalary=employeeSalary*2;
		System.out.println("Employee Salary:: "+calculateSalary);
		
	}
}
