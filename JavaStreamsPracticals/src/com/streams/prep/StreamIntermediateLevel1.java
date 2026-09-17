package com.streams.prep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamIntermediateLevel1 {
	public static void main(String[] args) {
		
		List<Employee> empList=Arrays.asList(
		new Employee(101, "Nagendra", 50000, "Development"),
		new Employee(102, "Radha", 30000, "HR"),
		new Employee(103, "Krishna", 40000, "Tester"),
		new Employee(104, "Sulochana", 60000, "Development"),
		new Employee(105, "Sudha", 50000, "HR"),
		new Employee(106, "Ravi", 44000, "Tester"));
		
		//Q1)Sort List of Employees By Salary
		 List<Employee> listOfEmployeeBasedOnSalary=empList.stream()
		.sorted(Comparator.comparingDouble(Employee::getEmpSalary))
		.collect(Collectors.toList());
		 
		 listOfEmployeeBasedOnSalary.forEach(System.out::println);
		 
		 //Q2)Grouping Employees by department and calculate average Salary
		 
		Map<String, Double> map= empList.stream()
		 .collect(Collectors.groupingBy(Employee::getEmpDepartment,
				 Collectors.averagingDouble(Employee::getEmpSalary)));
		System.out.println("========================================");
		
		System.out.println(map);
		
		map.forEach((department,averageSal)->{
			System.out.println(department+"-"+averageSal);
		});
				
		 //Q3)Find the highest paid employee in each department
		Map<String, Optional<Employee>> map2=empList.stream()
		.collect(Collectors.groupingBy(Employee::getEmpDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getEmpSalary))));
		System.out.println("===========================");
		map2.forEach((department,employee)->{
			System.out.println("Department Name "+department+" -> Employee Name "+employee.get().getEmpName()+" -> Employee Salary "+employee.get().getEmpSalary());
		});
		System.out.println(map2);
		
		System.out.println("==========================================");
		//	Q4)find all department with more than or equals 2 employees
		
		 Map<String, Long> map3 =empList.stream()
		.collect(Collectors.groupingBy(Employee::getEmpDepartment,Collectors.counting()));
		 
		 System.out.println(map3);
		 
		 List<String> stringOjects=map3.entrySet().stream()
		 .filter(entry->entry.getValue()>=2)
		 .map(Map.Entry::getKey)
		 .toList();
		 
		 System.out.println(stringOjects);
		 
		 //combine all the logic
		 
		 empList.stream()
		 .collect(Collectors.groupingBy(Employee::getEmpDepartment,Collectors.counting()))
		 .entrySet().stream()
		 .filter(entry->entry.getValue()>=2)
		 .map(Map.Entry::getKey)
		 .collect(Collectors.toList())
		 .forEach(str->System.out.println(str));
		 
		 
		System.out.println("============================================");
		//Q5)find department with the highest average salary
		
		Map<String, Double> departmentMap =empList.stream()
		.collect(Collectors.groupingBy(Employee::getEmpDepartment,
				Collectors.averagingDouble(Employee::getEmpSalary)));
		
		System.out.println(departmentMap);
		
			Entry<String,Double> entry=departmentMap.entrySet().stream()
		.max(Map.Entry.comparingByValue())
		.orElseThrow(()->new NoSuchElementException("No Entry found"));
		 
		 System.out.println(entry);
		 //combind all the logic
		 
		Entry<String, Double> entry1=empList.stream()
		 .collect(Collectors.groupingBy(Employee::getEmpDepartment,
		  Collectors.averagingDouble(Employee::getEmpSalary)))
		 .entrySet().stream()
		 .max(Map.Entry.comparingByValue())
		.orElseThrow(()->new NoSuchElementException("No Department is found with max average salary"));
		 System.out.println("===========================================");
		 System.out.println(entry1);
		 
		 //Q6)find most frequent Character in String
		      
		    String input="banana";
		   //convert input to Stream of Characters
		    
		  Entry<Character, Long> charEntry= input.chars().mapToObj(character->(char)character)
		    .collect(Collectors.groupingBy(Character::charValue,Collectors.counting()))
		    .entrySet().stream()
		    .max(Map.Entry.comparingByValue())
		    .orElseThrow(()-> new NoSuchElementException("Character is not Found"));
		   
		   System.out.println(charEntry);
		   System.out.println("=============================================");
		   
		   //Q7) Find first non repeating character in String
		 Entry<Character, Long> entry3  =input.chars().mapToObj(character->(char)character)
		   .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet()
		   .stream().filter(entryValue->entryValue.getValue()==1).findFirst()
		   .orElseThrow(()->new NoSuchElementException("No Entry is found"));
		  
		 System.out.println(entry3);
	

}}
