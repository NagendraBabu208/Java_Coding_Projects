package com.streams.userdefined;

public class Employee {
	
	private int empId;
	private String empName;
	private String city;
	private double empSalary;
	private String empDepartment;
	
	public Employee() {
	}

	public Employee(int empId, String empName, String city, double empSalary, String empDepartment) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.city = city;
		this.empSalary = empSalary;
		this.empDepartment = empDepartment;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", city=" + city + ", empSalary=" + empSalary
				+ ", empDepartment=" + empDepartment + "]";
	}
	
	

}
