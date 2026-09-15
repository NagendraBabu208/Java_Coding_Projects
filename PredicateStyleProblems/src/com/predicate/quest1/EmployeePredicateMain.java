package com.predicate.quest1;

import java.util.Arrays;
import java.util.List;

public class EmployeePredicateMain {
	
	public static void main(String[] args) {
		List<Employee> listOfEmployess=Arrays.asList(
				new Employee(1, "Nagendra", "IT", 25000),
				new Employee(2, "VasuDev", "NonIT", 50000),
				new Employee(3, "Naga Vasu", "Mechanical", 25000),
				new Employee(4, "Mahendra", "IT", 50000),
				new Employee(5, "Vamsi", "IT", 25000));
		
		IEmployeePredicate predicate=employee-> employee.getEmpDepartment().equals("IT");
			
			for(Employee employee:listOfEmployess) {
				if(predicate.checkEmpDepartment(employee)) {
					System.out.println(employee);
				}
			}
		
			
		
	}

}
