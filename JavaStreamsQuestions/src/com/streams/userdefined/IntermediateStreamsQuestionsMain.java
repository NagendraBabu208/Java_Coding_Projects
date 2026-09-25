package com.streams.userdefined;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntermediateStreamsQuestionsMain {
	
	public static void main(String[] args) {
		List<Employee> listOfEmployees=Arrays.asList(
				new Employee(101, "Naga", "Koppal", 50000, "IT"),
				new Employee(102, "Suriya", "Bangalore", 45000, "HR"),
				new Employee(103, "Mamitha", "Hyderabad", 60000, "Finance"),
				new Employee(104, "Ravi", "Chennai", 55000, "IT"),
				new Employee(105, "Priya", "Pune", 47000, "Marketing"),
				new Employee(106, "Kiran", "Mumbai", 52000, "Sales"),
				new Employee(107, "Anitha", "Pune", 48000, "HR"),
				new Employee(108, "Vikas", "Kolkata", 61000, "Finance"),
				new Employee(109, "Deepa", "Mysore", 53000, "IT"),
				new Employee(110, "Arjun", "Pune", 46000, "Marketing"),
				new Employee(111, "Sneha", "Nagpur", 49000, "Sales"),
				new Employee(112, "Rahul", "Lucknow", 58000, "Finance"));
	
	//6. Check if all employees have a salary greater than a specific Value
        boolean value=listOfEmployees.stream()
        .allMatch(emp->emp.getEmpSalary()>50000);
        System.out.println(value);
        System.out.println("=========================================");
     //   7. Get the sum of salaries of all employees and the average salary
        DoubleSummaryStatistics doubleSummaryStatistics=listOfEmployees.stream()
        .collect(Collectors.summarizingDouble(Employee::getEmpSalary));
        
        System.out.println("AllEmployeesSalarySum = "+doubleSummaryStatistics.getSum());
        System.out.println("AllEmployeesSalaryAverage = "+doubleSummaryStatistics.getAverage());
        System.out.println("==================================================");

       //8. Get a Map of Employee Names and their salaries
        
        Map<String, Double> employeeNamesSalariesMap=listOfEmployees.stream()
        .collect(Collectors.groupingBy(Employee::getEmpName,LinkedHashMap::new,Collectors.averagingDouble(Employee::getEmpSalary)));
        System.out.println(employeeNamesSalariesMap);
        System.out.println("==================================================");
        
       // 9. Print the employee details from highest to lowest salary
        
        listOfEmployees.stream()
        .sorted(Comparator.comparing(Employee::getEmpSalary).reversed())
        .forEach(System.out::println);
        System.out.println("==============================================");

 
        
	}

}
