package com.streams.quest1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample01 {
	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee(101, "Nagendra", "IT", 60000, 28),
			    new Employee(102, "Ravi", "HR", 45000, 32),
			    new Employee(103, "Suresh", "IT", 75000, 35),
			    new Employee(104, "Kiran", "Finance", 55000, 29),
			    new Employee(105, "Arun", "HR", 50000, 26),
			    new Employee(106, "Rahul", "IT", 65000, 31),
			    new Employee(107, "Vijay", "Finance", 80000, 38),
			    new Employee(108, "Prakash", "Sales", 40000, 24),
			    new Employee(109, "Mahesh", "Sales", 60000, 30),
			    new Employee(110, "Raj", "IT", 75000, 27)
			);
		
		//1)Find all employees whose salary is greater than 60,000
		
		employees.stream()
		.filter(emp->emp.getSalary()>60000)
		.forEach(System.out::println);
		
		System.out.println("===================================");
		
		//2)Get the names of all employees belonging to the IT department.
		
		employees.stream()
		.filter(emp->emp.getDepartment().equals("IT"))
		.map(emp->emp.getName())
		.forEach(System.out::println);
		
		System.out.println("===================================");
		
		//3) Sort all employees by salary in descending order.
		
		employees.stream()
		.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
		.forEach(System.out::println);
		
		System.out.println("========================================");
		//4) Find the number of employees whose age is greater than 30.
		long count=employees.stream()
		.filter(emp->emp.getAge()>30)
		.count();
		System.out.println(count);
		
		System.out.println("========================================");

		
		//5 Distinct departments
	     List<String> departmentNames=employees.stream()
		.map(emp-> emp.getDepartment())
		.distinct()
		.collect(Collectors.toList());
		System.out.println(departmentNames);
		
		
		
	}

}
