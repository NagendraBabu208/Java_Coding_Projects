package com.functional.quest1;

public class StudentMain {
	
	public static void main(String[] args) {
		
		Student[] studentArray=new Student[] {
			new Student(1, "Nagendra", 85),
			new Student(2, "Vasudev", 60),
			new Student(3, "Mani", 90),	
			 
		};
	
		IStudentFunctional functional=student->student.getMarks()>75;	
		
		
		for(Student student:studentArray) {
			System.out.println(functional.test(student));
		}
		
	}

}
