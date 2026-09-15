package com.predicate.quest1;

import java.util.Arrays;
import java.util.List;

public class IEmployeePredicateMain3 {

	public static void main(String[] args) {
		
		List<Employee> listOfEmployess=Arrays.asList(
				new Employee(1, "Nagendra", "IT", 25000),
				new Employee(2, "VasuDev", "NonIT", 60000),
				new Employee(3, "Naga Vasu", "Mechanical", 25000),
				new Employee(4, "Mahendra", "IT", 65000),
				new Employee(5, "Vamsi", "Civil", 25000),
				new Employee(6, "Mani", "IT", 90000));
		
		
		/*
		 * IEmployeePredicate2 predicate2=
		 * employee->employee.getEmpDepartment().equals("IT") ||
		 * employee.getEmpSalary()>80000;
		 * 
		 * for(Employee employee:listOfEmployess) {
		 * if(predicate2.checkEmpConditions(employee)) {
		 * System.out.println(employee.getEmpName()+" -> "+predicate2.checkEmpConditions
		 * (employee)); } }
		 */
		

		IEmployeePredicate2 predicate3=
				employee->!(employee.getEmpDepartment().equals("IT"));
			
			for(Employee employee:listOfEmployess) {

				System.out.println(employee.getEmpName()+" -> "+predicate3.checkEmpConditions(employee));
				
				
			}
	}

}
