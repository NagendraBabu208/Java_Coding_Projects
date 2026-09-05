package com.abstraction.model;

public abstract class TeamLead extends Employee {
	
	String  projectName;

	public TeamLead(String employeeName, int employeeId,String employeeType, String projectName) {
		super(employeeName, employeeId,employeeType);
		this.projectName = projectName;
	}
	
	
	void teamLeadDetails() {
		System.out.println("Employee Name::- "+employeeName);
		System.out.println("Employee Id::- "+employeeId);
		System.out.println("Employee Project Name::- "+projectName);
		System.out.println("Employee Type::- "+employeeType);
		System.out.println("Employee Company Name::-"+COMPANYNAME);
		
	}
	

}
