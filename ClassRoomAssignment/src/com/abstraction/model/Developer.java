package com.abstraction.model;

public class Developer extends TeamLead {

	

	public Developer(String employeeName, int employeeId, String employeeType, String projectName) {
		super(employeeName, employeeId, employeeType, projectName);
		
	}

	@Override
	void calcBonus(int amount) {
		
		int bouns=amount*2;
		System.out.println("Bonus::- "+bouns);
	
	}
	
	public String[] showHabbies() {
		return new String[] {"Cricket","Backet Ball","Carroms"};
	}

}
