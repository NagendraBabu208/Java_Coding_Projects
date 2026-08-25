package com.basics.quest3;


import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {

		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the student one  name:: ");
		String firstStudentName=scanner.nextLine();
		System.out.println(" enter the student one departmentId ::");
		String firstStudentDepartmentId=scanner.nextLine(); 

		System.out.println("enter the no of subjects of first student:: ");
		int lengthofArrayOne =scanner.nextInt();

		int[] marksArray1=new int[lengthofArrayOne];

		for(int i=0;i<marksArray1.length;i++) {
			System.out.println(" enter the subject marks ");
			marksArray1[i]=scanner.nextInt();
		}
		scanner.nextLine();
		Student student1=new Student(firstStudentName, firstStudentDepartmentId);

		System.out.println("enter the second student  name:: ");
		String secondStudentName=scanner.nextLine();
		System.out.println(" enter the second student departmentId ::");
		String secondStudentDepartmentId=scanner.nextLine(); 

		System.out.println("enter the no of subjects of second student:: ");
		int lengthofArrayTwo =scanner.nextInt();

		int[] marksArray2=new int[lengthofArrayTwo];

		for(int i=0;i<marksArray2.length;i++) {
			System.out.println(" enter the subject marks ");
			marksArray2[i]=scanner.nextInt();
		}


		Student student2=new Student(secondStudentName, secondStudentDepartmentId);

		// print details
		System.out.println("first student details and Grade");
		student1.printStudentDetails();
		System.out.println(" first Student Grade:: "+student1.getGrades(marksArray1));
		System.out.println("============================================================");
		System.out.println("second student details and Grade");
		student2.printStudentDetails();
		System.out.println(" first Student Grade:: "+student2.getGrades(marksArray2));


		if(scanner!=null) {
			scanner.close();
		}



	}

}
