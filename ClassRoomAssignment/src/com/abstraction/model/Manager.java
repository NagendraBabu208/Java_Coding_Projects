package com.abstraction.model;

public class Manager extends Employee {
   double salary;
	public Manager(String employeeName, int employeeId,String employeeType,double salary) {
		super(employeeName, employeeId,employeeType);
		this.salary=salary;
		
		
	}
	@Override
	void calcBonus(int amount) {
		int bonus=amount*5;
		System.out.println("Bonus::-"+bonus);
		
	}
	
  public String[] trainingDetails() {
		return new String[] {"Java","Python","PHP"};
	}

}
