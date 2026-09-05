package com.abstraction.model;

import java.util.Scanner;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		Employee employee=null;
		Scanner scanner= new Scanner(System.in);
		boolean isEmployeeAvailable=true;
		while(isEmployeeAvailable) {
		System.out.println("Select Type of Employee::-(Manager/TeamLead/Developer) ");
		String employeeType=scanner.nextLine();
		
		if("MANAGER".equalsIgnoreCase(employeeType)) {
			employee=new Manager("Nagendra", 1259975,"Manager", 55000.0);
			employee.calcBonus(10000);
			employee.printDetails();
			Employee.projectDetails();//static method
			employee.salaryProcess();//final method
			System.out.println("==================Employee Specific Method======================");
			Manager manager=(Manager) employee;
			String[] courses=manager.trainingDetails();
			for(String course:courses) {
				System.out.println("Couse Name::-"+course);
			}
		}else if("TEAMLEAD".equalsIgnoreCase(employeeType)) {
			
			employee=new Developer("SriniVasarao", 1259976, "TeamLead","SAP Business One Project");
			System.out.println("=================Team Lead Specific Details========================");
			TeamLead teamLead=(TeamLead) employee;
			teamLead.teamLeadDetails();
			Employee.projectDetails();//static method
			teamLead.salaryProcess();//final method
		}else if("DEVELOPER".equalsIgnoreCase(employeeType)) {
			employee=new Developer("VasuDev", 1259974, "Developer", "SAP Project");
			employee.printDetails();
			employee.salaryProcess();//final method
			Employee.projectDetails();//static method
			System.out.println("===============================Developer Specific Details============");
			Developer developer=(Developer) employee;
			String[] habbies=developer.showHabbies();
			for(String habby:habbies) {
				System.out.println("Hobby is::- "+habby);
				
			}
			
			}else {
				System.out.println("Invalid Employee Type!!!. Please select Valid option.");
				continue;
			}
		}
		
		if(scanner!=null) {
			scanner.close();
		}
	}
}
