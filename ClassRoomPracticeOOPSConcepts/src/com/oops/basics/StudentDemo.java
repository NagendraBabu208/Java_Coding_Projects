package com.oops.basics;

public class StudentDemo {
	
	public static void main(String[] args) {
		Student student= new Student("Rohan",20);
		//call the methods using . operator
		student.printStudentDetails();
		Student student2= new Student("Jyothi",10);
		student2.printStudentDetails();
		
	}

}
