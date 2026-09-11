package com.custom.objects;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		List<Employee> employeesList=Arrays.asList(
				new Employee(1, "Nagendra", 50000.0),
				new Employee(2, "Samba", 45000.0),
				new Employee(3, "SriKanth", 90000.0),
				new Employee(4, "Vasu", 30000.0),
				new Employee(5, "Gayathri", 26000.0));
		
		
		//find maximum salary
		
		Function<List<Employee>, Double> function= employees->{
			double maxSalary=0;
			
			for(Employee employee:employees) {
				
				if(employee.getEmpSalary()>maxSalary) {
					maxSalary=employee.getEmpSalary();
				}
				
			
			
		}
			return maxSalary;
	};
	
	System.out.println(function.apply(employeesList));
	
	
	List<Integer> listOfIntegers=Arrays.asList(10,15,20,25,30);
	
	BiPredicate<List<Integer>,Integer> predicate=(numbersList,number)->{
		
		
		for(int num:numbersList) {
			if(num>number) {
				return true;
			}
			}
		return false;
		
		
	};
	System.out.println(predicate.test(listOfIntegers, 20));

}

}
