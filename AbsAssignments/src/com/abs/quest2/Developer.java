package com.abs.quest2;

public class Developer extends TeamLead {

	String[] hobbies;

	public Developer(String empName, double empSalary, int empId,String[] hobbies) {
		super(empName, empSalary, empId);
		this.hobbies=hobbies;

	}

	

	@Override
	void showProjects() {
		System.out.println("We have java projects and Developers!!!.");
		System.out.println("We have react projects and Developers!!!.");
}
	
	public void showHobbies() {
		
		for(String hobby:hobbies) {
			System.out.println(hobby+" is my hobby!!!.");
			
		}
		
		
	}

}
