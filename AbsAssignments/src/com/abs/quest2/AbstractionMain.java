package com.abs.quest2;

import java.util.Scanner;

public class AbstractionMain {

	public static void main(String[] args) {
		Employee employee=null;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the Employee Type(Manager/TeamLead/Developer:: ");
		String employeeType=scanner.nextLine();
		
		switch(employeeType.toUpperCase()){
		case"MANAGER":
			employee=new Manager("Manjunath", 200000, 1259989, "monitoring the teams works");
			employee.calcBonus(50000);
			employee.showProjects();
			employee.printDetails();
			System.out.println(employee.COMPANYNAME);//final variable
			String[] courses=employee.showCourses();
			for(String course:courses) {
				System.out.println(course);
			}
			employee.showRules();//final method
			
			System.out.println("==================Manager Specific Details=============================");
			Manager manager=(Manager) employee;
			manager.funClub();
			scanner.nextLine();
			break;
		case "TEAMLEAD":
			employee=new Developer("Nagendra", 50000, 1259976,new String[] {"Java","Srping","Spring Boot"});
			System.out.println("=================================Team Lead Specific===================================");
			TeamLead lead=(TeamLead) employee;
			lead.printDetails();
			lead.calcBonus(30000);
			
		    String[] leadCourses=lead.showCourses();
			for(String course:leadCourses) {
				System.out.println(course);
			}
		    lead.showProjects();
			lead.showRules();
			System.out.println(lead.COMPANYNAME);
			scanner.nextLine();
			break;
		case"DEVELOPER":
			employee=new Developer("Radha", 50000, 1259975,new String[] {"Singing","Watching","Coding"});
			employee.printDetails();
			employee.showProjects();
			System.out.println("============================================developer specific ");
			Developer developer=(Developer) employee;
			developer.showHobbies();
			
			break;
			default:
				System.out.println("Invalid employee type");
			
			
			
		}
	}
}
