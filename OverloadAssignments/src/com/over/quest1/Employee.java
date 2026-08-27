package com.over.quest1;

public class Employee {
	
	private String empName;
	private String empDesignation;
	
	
	
	public Employee(String empName, String empDesignation) {
		this.empName = empName;
		this.empDesignation = empDesignation;
	}

	public void calcBonus(double basicAllowance) {
		System.out.println("one arg ");
		System.out.println("Employee Name:: "+empName+"\t empDesignation:: "+empDesignation);
        System.out.println("Basic Allowance:: "+basicAllowance);
	}
	
	public void calcBonus(double basicAllowance,String gift) {
		System.out.println(" two args");
		System.out.println("Employee Name:: "+empName+"\t empDesignation:: "+empDesignation);
        System.out.println("Basic Allowance:: "+basicAllowance);
		System.out.println("Gift:: "+gift);
		
	}
	
	public void calcBonus(double basicAllowance,String gift,double houseAllowance) {
		System.out.println(" three args ");
		System.out.println("Employee Name:: "+empName+"\t empDesignation:: "+empDesignation);
		System.out.println("Basic Allowances:: "+basicAllowance);
		System.out.println("Gift:: "+gift);
		System.out.println("House Allowances:: "+houseAllowance);
		
	}
	
	public String getEmpDesignation() {
		return empDesignation;
	}

}
