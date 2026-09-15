package com.functional.quest2;

public class EmployeeMain4 {
	
	public static void main(String[] args) {
		Employee emp1=new Employee(1, "Nagendra", 70000);
		Employee emp2=new Employee(2, "Vasudev", 80000);
		
		IEmployeeFunctional4 functional4=(employee1,employee2)->{
			
			double maxSalary=employee1.getEmpSalary();
			
			Employee maximumSalaryEmployee= null;
			
			if(employee2.getEmpSalary()>maxSalary) {
				maxSalary=employee2.getEmpSalary();
				maximumSalaryEmployee=employee2;
				
			}else if(employee2.getEmpSalary()==maxSalary) {
				maximumSalaryEmployee=employee1;
			}
			else {
				maximumSalaryEmployee=employee1;
				
			}
			
			return maximumSalaryEmployee;
		};
		
		Employee highestSalaryEmployee=functional4.compareEmployeesBasedOnSalary(emp1, emp2);
		System.out.println(highestSalaryEmployee);
		
		
	}

}
