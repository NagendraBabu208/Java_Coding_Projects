package com.functional.quest2;



public class EmployeeMain2 {
	
	public static void main(String[] args) {
		
		Employee[] empArray=new Employee[] {
				new Employee(1, "Nagendra", 50000),
				new Employee(2, "Vasudev", 60000),
				new Employee(3, "Vamsi", 80000)
		};
		
		IEmployeeFunctional2 functional2=employee->{
			if(employee.getEmpSalary()<100000 && employee.getEmpSalary()>50000) {
				return true;
			}
			else {
				return false;
			}
		};
		
		for(Employee employee:empArray) {
			
			System.out.println(employee.getEmpName()+" -> "+functional2.checkEmp(employee));
		}
	}

}
