package com.streams.userdefined;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EmployeeBasicsMain {

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

		// Find all employees from a specific city and get the count

		List<Employee> listOfEmpSpecificCity=listOfEmployees.stream().filter(emp->emp.getCity().equals("Pune"))
				.collect(Collectors.toList());
		System.out.println(listOfEmpSpecificCity);
		long empCount=listOfEmpSpecificCity.stream().count();
		System.out.println(empCount);
		System.out.println("==============================================");

		//2. Find all employees where salary is greater than a particular value
		List<Employee> listOfEmpSalaryBySpecificValue=listOfEmployees.stream()
				.filter(emp->emp.getEmpSalary()>50000)
				.collect(Collectors.toList());
		listOfEmpSalaryBySpecificValue.forEach(System.out::println);
		System.out.println("=====================================================");

		//3. Print all the employee names only in upper case and alphabetical order
		listOfEmployees.stream()
		.sorted(Comparator.comparing(Employee::getEmpName))
		.map(emp->emp.getEmpName().toUpperCase())
		.forEach(System.out::println);
		
		System.out.println("============================================");
//4. Get the first employee where dept is "HR" and if not available throw exception
   Employee employee=listOfEmployees.stream()
   .filter(emp->emp.getEmpDepartment().equals("HR"))
   .findFirst()
   .orElseThrow(()->new NoSuchElementException("Employee is not found with department HR "));
   System.out.println(employee);
   System.out.println("===============================================================");
	
	//5. Get the total salary of all employees in a specific department
   
   Double hrDepartmentSalary=listOfEmployees.stream()
   .filter(emp->emp.getEmpDepartment().equals("HR"))
   .mapToDouble(Employee::getEmpSalary)
   .sum();
   System.out.println(hrDepartmentSalary);
   
	}

}
