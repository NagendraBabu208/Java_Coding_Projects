package com.functional.quest1;

public class Student {
	
	private Integer studentId;
	private String studentName;
	private int marks;
	
	public Student() {
		
	}

	public Student(Integer studentId, String studentName, int marks) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.marks = marks;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", marks=" + marks + "]";
	}
	


}
