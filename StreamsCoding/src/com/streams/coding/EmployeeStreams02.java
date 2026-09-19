package com.streams.coding;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmployeeStreams02 {
	
	public static void main(String[] args) {
		
	
List<Employee> listOfEmployees=EmployeeDetails.getEmployees();
//14.Group all employees by department 
   Map<String, List<Employee>> map=listOfEmployees.stream()
   .collect(Collectors.groupingBy(Employee::getEmpDept));
   
   System.out.println(map);
   System.out.println("==============================================");
   //15.Get the count of employees by department
   Map<String, Long> map1=listOfEmployees.stream()
		   .collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.counting()));
   System.out.println(map1);
   System.out.println("===========================================");
   //1 6.Get the sum of salaries of all employees by department
   Map<String, Double> map2=listOfEmployees.stream()
		   .collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.summingDouble(Employee::getSalary)));
   System.out.println(map2);
   System.out.println("============================================");
   //17.Get the average salaries of all employees per department
   
   Map<String, Double> map3=listOfEmployees.stream()
   .collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.averagingDouble(Employee::getSalary)));
   
   System.out.println(map3);
   
   System.out.println("=======================================================");
   //18.Check if all employees belong to a specific department
   boolean value=listOfEmployees.stream()
   .allMatch(emp->emp.getEmpDept()
		   .equals("IT"));
   
   System.out.println(value);
   
   System.out.println("==============================================");
   //19.List all employees grouping by cities but belong to the same department
  Map<String, List<Employee>> map4= listOfEmployees.stream()
   .filter(emp->emp.getEmpDept().equals("IT"))
   .collect(Collectors.groupingBy(Employee::getEmpLocation));
  System.out.println(map4);
  System.out.println("================================================================");

  //20.Find the department with the highest average salary
    Entry<String, Double> departmentWithHighestAvgSalary =listOfEmployees.stream()
  .collect(Collectors.groupingBy(Employee::getEmpDept,
		  Collectors.collectingAndThen(
				  Collectors.summarizingDouble(Employee::getSalary), 
				 DoubleSummaryStatistics::getAverage)))
  .entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue))
  .orElseThrow(()-> new NoSuchElementException("Not found department with average Salary!!!"));
    
    System.out.println(departmentWithHighestAvgSalary);

	}

}
