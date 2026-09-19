package com.streams.coding;

public class Employee {
	
	private String empName;
	private Integer empId;
	private double salary;
	private String empLocation;
	private String empDept;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, Integer empId, double salary, String empLocation, String empDept) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
		this.empLocation = empLocation;
		this.empDept = empDept;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", salary=" + salary + ", empLocation="
				+ empLocation + ", empDept=" + empDept + "]";
	}
	

	
	
	
	

}
