package com.streams.practicals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsChallenge5 {
	
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Nagendra", "IT", 50000),
			    new Employee(102, "Rahul", "HR", 40000),
			    new Employee(103, "Anil", "IT", 70000),
			    new Employee(104, "Priya", "Finance", 60000),
			    new Employee(105, "Sneha", "IT", 70000),
			    new Employee(106, "Raj", "HR", 45000)
			);
		//finding highest salary
		
		 Double maxSalary1=employees.stream()
		.filter(emp->emp.getDepartment().equals("IT"))
		.mapToDouble(Employee::getSalary).max().orElse(0);
	
		
		
		employees.stream().
		filter(emp->emp.getDepartment().equals("IT"))
		.filter(emp->emp.getSalary()==maxSalary1)
		.forEach(emp-> System.out.println(emp.getName()+" - "+emp.getSalary()));
		System.out.println("=====================================");
		//Find the highest-paid employee in each department.
		
		Map<String, Optional<Employee>> map=employees.stream()
			.collect(Collectors.groupingBy(Employee::getDepartment, 
					Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		
		 map.forEach((department,employee)->{
			 employee.ifPresent(emp->System.out.println(department+ "->" +emp.getName()+" - "+emp.getSalary()));
			 
		 });
		
		
		
		
	}

}
