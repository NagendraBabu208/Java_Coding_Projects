package com.oops.basics;

public class Student {
	
	private String studentName;
	private int studentId;
	
	public Student(String studentName,int studentId) {
	this.studentName=studentName;
	this.studentId=studentId;
	}
	
	void printStudentDetails() {
		System.out.println(" Student name ::"+studentName);
		System.out.println(" Student Id ::"+studentId);
	}

}
