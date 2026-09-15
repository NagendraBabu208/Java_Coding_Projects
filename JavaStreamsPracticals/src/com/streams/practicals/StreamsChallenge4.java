package com.streams.practicals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamsChallenge4 {
	
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Nagendra", "IT", 75000),
			    new Employee(102, "Ravi", "HR", 45000),
			    new Employee(103, "Anil", "IT", 65000),
			    new Employee(104, "Kiran", "Finance", 55000),
			    new Employee(105, "Suresh", "IT", 90000),
			    new Employee(106, "Abhi", "HR", 40000)
			);
		
		String empName=employees.stream().distinct()
		.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
		.skip(1).findFirst()
		.map(emp->emp.getName()).orElseThrow(()->new NoSuchElementException("Name is not found"));
		System.out.println(empName);
	}

}
