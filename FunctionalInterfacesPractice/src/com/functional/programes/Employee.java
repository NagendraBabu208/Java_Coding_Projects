package com.functional.programes;

public class Employee {
	
	private String empName;
	private Integer empId;
	private String empAddress;
	private double empSalary;
	
	public Employee() {
		
	}

	public Employee(String empName, Integer empId, String empAddress, double empSalary) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empAddress=" + empAddress + ", empSalary="
				+ empSalary + "]";
	}
	
	

}
