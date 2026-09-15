package com.functional.quest2;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		Employee[] empArray=new Employee[] {
				new Employee(1, "Nagendra", 50000),
				new Employee(2, "Vasudev", 60000),
				new Employee(3, "Vamsi", 80000)
		};
		
		IEmployeeFuctional fuctional=employee->employee.getEmpSalary();
		
		for(Employee employee:empArray) {
			System.out.println(fuctional.getSalary(employee));
		}
	}

}

