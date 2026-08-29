package com.abs.quest2;

public class Manager extends Employee {
	
      String activity;
	

	public Manager(String empName, double empSalary, int empId, String activity) {
		super(empName, empSalary, empId);
		this.activity = activity;
	}

	@Override
	public void calcBonus(double amount) {
	 
		double bonus=empSalary+amount*5;
		System.out.println("Bonus of Manager ="+bonus);
		

	}
	
	public void printDetails() {
		super.printDetails();
		System.out.println("Activity:: "+activity );
		
	}

	@Override
	public void showProjects() {
		System.out.println("We have java projects!!!.");
		System.out.println("We have react projects!!!.");
		}
	
	public void funClub() {
		System.out.println("Activity:: "+activity);
		
	}

}
