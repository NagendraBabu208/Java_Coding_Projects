package com.streams.quest1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamIntermediateLevel {
	
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
		
		//6. Highest-paid employee
		
		employees.stream()
		.max(Comparator.comparingDouble(Employee::getSalary))
		.ifPresent(emp->System.out.println(emp));
		
		// 7)Find the employee with the lowest salary in the IT department.
		Employee employee=employees.stream()
		.filter(emp->emp.getDepartment().equals("IT"))
		.min(Comparator.comparingDouble(Employee::getSalary))
		.orElseThrow(()->new NoSuchElementException("Employee is not found"));
		
		System.out.println(employee);
		System.out.println("======================================");
		//8) Calculate the average salary of all employees.
		Double averageSalary=employees.stream()
		.collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(averageSalary);
		
		//9)Calculate the total salary of all employees belonging to the Finance department.
		System.out.println("================================================");
		
		 double sumofEmployessSalaryByFinanceDept=employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summarizingDouble(Employee::getSalary)))
		.entrySet().stream().filter(entry->entry.getKey().equals("Finance"))
		.map(entry->entry.getValue().getSum())
		.findAny()
		.orElseThrow(()->new NoSuchElementException("No Finance department is not available!!!"));
		 System.out.println(sumofEmployessSalaryByFinanceDept);
		 System.out.println("=============================================================");
		 
		 double sumofSalary=employees.stream().filter(emp->emp.getDepartment().equals("Finance"))
		 .collect(Collectors.summingDouble(Employee::getSalary));
		 System.out.println(sumofSalary);
		 
		 //10)Find the names of employees who satisfy all three conditions:
    //Department is IT, Salary is greater than 65,000,Age is less than 35
		System.out.println("===========================================");
		 employees.stream()
		 .filter(emp->emp.getDepartment().equals("IT") && emp.getSalary()>65000 && emp.getAge()<35)
		 .map(emp->emp.getName())
		 .forEach(System.out::println);
		
		
	//11)Group all employees by department.	
		 System.out.println("==================================================");
		 
		 Map<String, List<Employee>> listOfEmployeesBasedOnDepartmentWise =employees.stream()
		 .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
		 System.out.println(listOfEmployeesBasedOnDepartmentWise);
		 
	//Q12 — Count employees by department
		 System.out.println("==================================================");
		Map<String, Long> departmentWiseEmployeesCount= employees.stream()
		 .collect(Collectors.groupingBy(Employee::getDepartment,LinkedHashMap::new, Collectors.counting()));
		System.out.println(departmentWiseEmployeesCount);
		
		//Q13 — Average salary by department
		System.out.println("==================================================");
		
		Map<String, Double> averageSalaryOfEachDepartment =employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,LinkedHashMap::new,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalaryOfEachDepartment);
		
		System.out.println("=======================================");
		//Q14) find the highest-paid employee from each department.
		
		Map<String, Optional<Employee>> map =employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		
		System.out.println(map);
		
		System.out.println(" ============================================= ");
		Map<String, Employee> map1 =employees.stream()
		.collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.collectingAndThen(
				Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
				Optional::get)));
		
		System.out.println(map1);


	}

}
