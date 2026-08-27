package com.over.quest1;

import java.util.Scanner;

public class OverloadMain {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		//reading 5 employee names and designation using scanner class
		System.out.println("enter first employee name:: ");
		String firstEmpName=scanner.nextLine();
		System.out.println("enter first employee designation:: ");
		String firstEmpDesignation=scanner.nextLine();
		
		System.out.println("enter second employee name:: ");
		String secondEmpName=scanner.nextLine();
		System.out.println("enter second employee designation:: ");
		String secondEmpDesignation=scanner.nextLine();
		
		System.out.println("enter third employee name:: ");
		String thirdEmpName=scanner.nextLine();
		System.out.println("enter third employee designation:: ");
		String thirdEmpDesignation=scanner.nextLine();
		
		System.out.println("enter fourth employee name:: ");
		String fourthEmpName=scanner.nextLine();
		System.out.println("enter fourth employee designation:: ");
		String fourthEmpDesignation=scanner.nextLine();
		
		System.out.println("enter fifth employee name:: ");
		String fifthEmpName=scanner.nextLine();
		System.out.println("enter fifth employee designation:: ");
		String fifthEmpDesignation=scanner.nextLine();
		
		
		
		//creating 5 employee objects
		Employee employee1=new Employee(firstEmpName,firstEmpDesignation);
		Employee employee2= new Employee(secondEmpName, secondEmpDesignation);
		Employee employee3=new Employee(thirdEmpName, thirdEmpDesignation);
		Employee employee4= new Employee(fourthEmpName, fourthEmpDesignation);
		Employee employee5= new Employee(fifthEmpName, fifthEmpDesignation);
		
		//assigning employee objects to employee array
		Employee[] employeesArray= new Employee[5];
		employeesArray[0]=employee1;
		employeesArray[1]=employee2;
		employeesArray[2]=employee3;
		employeesArray[3]=employee4;
		employeesArray[4]=employee5;
		
		//iterate employee objects based on designation and perform operations
		
		for(Employee employee:employeesArray) {
			
			if("Programmer".equalsIgnoreCase(employee.getEmpDesignation())) {
				employee.calcBonus(50000.0);
				System.out.println("========================================================");
			}else if("Manager".equalsIgnoreCase(employee.getEmpDesignation())) {
				employee.calcBonus(100000.0, "Honda Car");
				System.out.println("========================================================");

			}else if("Director".equalsIgnoreCase(employee.getEmpDesignation())) {
				employee.calcBonus( 200000, "Duplex House", 50000.0);
				System.out.println("========================================================");
               }else {
            	   System.out.println(" unkown designation "+employee.getEmpDesignation());
               }
		}
	
		
		
		
		
	}

}
