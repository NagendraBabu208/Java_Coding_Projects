package com.streams.coding;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeStreams {
	
	public static void main(String[] args) {
		
		List<Employee> listOfEmployees=EmployeeDetails.getEmployees();
		
		Long count=listOfEmployees.stream()
		.filter(emp->emp.getEmpLocation().equals("Bangalore"))
		.count();
		
		System.out.println(count);
		System.out.println("===============================");
		
		listOfEmployees.stream()
				.filter(emp->emp.getSalary()>48000)
				.forEach(System.out::println);
		System.out.println("===================================");
		listOfEmployees.stream()
		.map(emp->emp.getEmpName())
		.sorted()
		.forEach(System.out::println);
		
		System.out.println("===================================");
		Employee employee=listOfEmployees.stream()
		.filter(emp->emp.getEmpDept().equals("HR"))
		.findFirst()
		.orElseThrow(()->new EmployeeNotFoundException("Employee is not Found!!!."));
		System.out.println(employee);
		System.out.println("===================================");
        
		
		Double totalSalaryOfDeptHR=listOfEmployees.stream()
		.filter(emp->emp.getEmpDept().equals("HR"))
		.mapToDouble(Employee::getSalary).sum();
		
		System.out.println(totalSalaryOfDeptHR);
		
		System.out.println("==================================");
		
		System.out.println("==================Intermediate Questions=================");
		
		boolean value=listOfEmployees.stream()
		.allMatch(emp->emp.getSalary()>48000);
		System.out.println(value);
		
		System.out.println("==============================================");
     
	DoubleSummaryStatistics doubleSummaryStatistics=listOfEmployees.stream()
	.collect(Collectors.summarizingDouble(Employee::getSalary));	
		
	System.out.println(doubleSummaryStatistics.getSum());
	System.out.println(doubleSummaryStatistics.getAverage());
	
	System.out.println("==============================================");
	
	Map<String, Double> map=listOfEmployees.stream()
	.collect(Collectors.groupingBy(Employee::getEmpName,
			Collectors.averagingDouble(Employee::getSalary)));
	
	System.out.println(map);
	System.out.println("===================================");
	
	listOfEmployees.stream()
	.sorted(Comparator.comparing(Employee::getSalary).reversed())
	.forEach(System.out::println);
	System.out.println("=======================================");
	
	Employee emp=listOfEmployees.stream()
	.max(Comparator.comparingDouble(Employee::getSalary))
	.orElseThrow(()->new EmployeeNotFoundException("Employee is not found!!!."));
	System.out.println(emp);	
	System.out.println("========================================");
	Employee secondHighestSalaEmployee=listOfEmployees.stream()
	.sorted(Comparator.comparing(Employee::getSalary).reversed())
	.skip(1)
	.findFirst()
	.orElseThrow(()-> new EmployeeNotFoundException("Employee is not found!!!"));
	System.out.println(secondHighestSalaEmployee);
	System.out.println("========================================");
	
            double avgSalary=listOfEmployees.stream()
			.collect(Collectors.averagingDouble(Employee::getSalary));
            
            listOfEmployees.stream().filter(nEmp->nEmp.getSalary()>avgSalary)
            .forEach(System.out::println);
			
	
	System.out.println("==================================");
	
	//13. Get the employee with the longest name
	
	
	  Employee employee2=listOfEmployees.stream() 
	  .max(Comparator.comparing(
			  Employee::getEmpName,
			  Comparator.comparingInt(String::length)))
	  .orElseThrow(()->new EmployeeNotFoundException("Employee is not found!!!."));
	  System.out.println(employee2);
	 
	
	
	
	}

}
