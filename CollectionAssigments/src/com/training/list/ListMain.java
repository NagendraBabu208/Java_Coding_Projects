package com.training.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListMain {
	
	public static void main(String[] args) {
		List<Employee> listOfEmployees=Arrays.asList(
				new Employee("Nagendra", 1257795, "Gachibowli"),
				new Employee("Vamsi", 1257796, "Gachibowli"),
				new Employee("Radha", 1257797, "Bangalore"),
				new Employee("Krishna", 1257798, "Gachibowli"),
				new Employee("Vasudha", 1257799, "Madhapur"));
		
		//1) iterate using forEach and print it
		
		for(Employee employee:listOfEmployees) {
			System.out.println(employee);
		}
		System.out.println("===========================================");
		//java 8 streams
		//listOfEmployees.stream().forEach(System.out::println);
		
		List<Employee> listOfEmployeesByCity=new ArrayList<Employee>();
		
		for(Employee employee:listOfEmployees) {
			if(employee.getEmpCity().equals("Gachibowli")) {
				listOfEmployeesByCity.add(employee);
			}
		}
		
		//java 8 filtering
		/*
		 * listOfEmployees.stream()
		 *  .filter(emp->emp.getEmpCity().equals("Gachibowli"))
		 * .collect(Collectors.toList())
		 * .forEach(System.out::println);
		 */
	
		listOfEmployeesByCity.stream().forEach(System.out::println);
	}

}
