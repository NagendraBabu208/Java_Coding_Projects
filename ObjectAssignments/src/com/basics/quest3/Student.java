package com.basics.quest3;

public class Student {

	private String name;
	private String department;

	public Student(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public void printStudentDetails() {
		System.out.println(" first Student name::"+name);
		System.out.println("first student department:: "+department);

	}

	public String getGrades(int[] marks) {

		int sum=0;
		int average=0;
		for(int mark:marks) {
			sum=sum+mark;
		}
		average=sum/(marks.length);

		System.out.println("Sum "+sum+"\taverage "+average);

		if (average >= 90 && average <= 100) {
			return "A Grade";
		} else if (average >= 80 && average < 90) {
			return "B Grade";
		} else if (average >= 70 && average < 80) {
			return "C Grade";
		} else if (average >= 60 && average < 70) {
			return "D Grade";
		} else if (average >= 50 && average < 60) {
			return "E Grade";
		} else {
			return "Fail";
		}


	}


}
