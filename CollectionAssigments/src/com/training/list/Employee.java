package com.training.list;

public class Employee {
	private String empName;
	private Integer empId;
	private String empCity;
	
	public Employee() {
	}

	public Employee(String empName, Integer empId, String empCity) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empCity = empCity;
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

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", empCity=" + empCity + "]";
	}
	
	
	

}
