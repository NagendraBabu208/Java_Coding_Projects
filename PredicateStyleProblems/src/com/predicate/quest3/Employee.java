package com.predicate.quest3;

public class Employee {
	
	private Integer empId;
	private String empName;
	private Integer empAge;
	
	public Employee() {
		
	}

	public Employee(Integer empId, String empName, Integer empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + "]";
	}
	

}
