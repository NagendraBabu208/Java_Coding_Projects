package com.predicate.quest3;

import java.util.Arrays;
import java.util.List;

public class EmployeePredicateMain {
	
	public static void main(String[] args) {
	List<Employee> listOfEmployees=Arrays.asList(
			new Employee(1, "Nagendra", 32),
			new Employee(2, "VasuDev", 23),
			new Employee(3, "Sulochana", 46),
			new Employee(4, "Naga Vamsi", 29),
			new Employee(5, "Chiranjeevi", 70));
	
	IEmployeePredicate2 predicate2=employee-> employee.getEmpAge()>=25;
	
	
	for(Employee employee:listOfEmployees) {
		System.out.println(employee.getEmpName()+" -> "+predicate2.checkEmployeeAge(employee));
	}
		
	}

}
