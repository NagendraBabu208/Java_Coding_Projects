package com.training.quest1;

import java.util.Scanner;

public class User {

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter user input value S->Student and E-> EmployeeCourses :: ");
		String userInput=scanner.nextLine();
		IInstitute institute=null;
		
		if("S".equalsIgnoreCase(userInput.toUpperCase())) {
			institute= new StudentCourses();
			String[] courses=institute.showCourses();
			for(String course:courses) {
				System.out.println(course);
			}
		}else if("E".equalsIgnoreCase(userInput.toUpperCase())) {
			institute = new EmployeeCourses();
			for(String course:institute.showCourses()) {
				System.out.println(course);
			}
		}else {
			
			System.out.println("Invalid Input!!!!");
			
		}
		
		if(scanner!=null) {
			scanner.close();
		}
	}
}
