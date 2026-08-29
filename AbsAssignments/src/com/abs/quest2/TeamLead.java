package com.abs.quest2;

public abstract class TeamLead  extends Employee{

	public TeamLead(String empName, double empSalary, int empId) {
		super(empName, empSalary, empId);
	}

	@Override
	void calcBonus(double amount) {
		
		double bouns=empSalary+amount*3;
		System.out.println("Bonus of Team Lead:: "+bouns);
		
	}
	
	public void corporateServies() {
		System.out.println("Team LEAD- We have perform various services like IT Services and Non IT Services");
	}
	
	
	

}
