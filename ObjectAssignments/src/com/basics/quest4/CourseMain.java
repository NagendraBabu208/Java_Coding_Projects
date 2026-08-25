package com.basics.quest4;

import java.util.Scanner;

public class CourseMain {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		Training training=new Training();
		String[] courses=training.showCourses();
		
		System.out.println("============Available Courses=======================");
		
		for(String course:courses) {
			System.out.println(course+" ");
		}
		
		System.out.println("===========Avaliable Trainers=======================");
		System.out.println("enter the trainer1 name::");
		String trainerOneName=scanner.nextLine();
		System.out.println("enter the trainer2 name::");
		String trainerTwoName=scanner.nextLine();
		System.out.println();
		training.showTrainers(trainerOneName,trainerTwoName);
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
