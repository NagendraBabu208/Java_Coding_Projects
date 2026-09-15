package com.functional.quest2;

public class EmployeeMain3 {
	
	public static void main(String[] args) {
		Employee[] empArray=new Employee[] {
				new Employee(1, "Nagendra", 50000),
				new Employee(2, "Vasudev", 60000),
				new Employee(3, "Vamsi", 80000),
				new Employee(4, "Radha", 90000)
				
		};
		
		IEmployeeFunctional3 functional3=employee->{
			
			double employeeIncrement=employee.getEmpSalary()*0.1;
			double empSalaryAfterIncrement=employee.getEmpSalary()+employeeIncrement;
			 employee.setEmpSalary(empSalaryAfterIncrement);
			 return employee.getEmpSalary();
		};
		
		for(Employee employee:empArray) {
			System.out.println(employee.getEmpName()+" -> "+functional3.calcSalaryAfterDiscount(employee));
		}
		
		
	}

}
