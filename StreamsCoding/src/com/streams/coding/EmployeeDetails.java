package com.streams.coding;

import java.util.Arrays;
import java.util.List;

public class EmployeeDetails {
	
	public static List<Employee> getEmployees() {
		return Arrays.asList(new Employee("Renjith", 100, 12000, "Mangalore", "Admin"),
				new Employee("Arun", 101, 45000, "Chennai", "IT"), 
				new Employee("Bala", 102, 55000, "Chennai", "HR"),
				new Employee("Karthik", 103, 60000, "Chennai", "Finance"),
				new Employee("Ravi", 104, 50000, "Chennai", "IT"),
				new Employee("Suresh", 105, 25000, "Bangalore", "IT"),
				new Employee("Vijay Kumar", 106, 18000, "Bangalore", "Sales"),
				new Employee("Monisha", 107, 50000, "Chennai", "IT"),
				new Employee("Mridhu", 108, 27000, "Bangalore", "IT"),
				new Employee("Kumaran", 109, 48000, "Bangalore", "Sales"));
	}

}
