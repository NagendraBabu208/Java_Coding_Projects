package com.functional.programes;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class EmployeeMain {
	
	public static void main(String[] args) {
		
		List<Employee> empList=Arrays.asList(
				new Employee("Nagendra", 1259975, "Gachibowli", 58000),
				new Employee("Nagarjuna", 1259976, "Pocharam", 60000),
				new Employee("Vamsi", 1259977, "Benz Circle", 80000),
				new Employee("Sulochana", 1259978, "Guntur", 40000),
				new Employee("Praveen", 1259979, "Gachibowli", 70000),
				new Employee("Srikanth", 1259980, "Gachibowli", 90000));
		
		System.out.println("Using consumer");
		Consumer<List<Employee>> consumer=(employeesList->{
			
			for(Employee employee:employeesList) {
				if(employee.getEmpName().startsWith("N")) {
				System.out.println(employee.getEmpName().toUpperCase());
				
				}}
		});
		
		consumer.accept(empList);
		//print employee details whose employee Address is Gachibowli
		BiConsumer<List<Employee>, String> biConsumer=(employeeList3,empAddress)->{
			
			for(Employee employee:employeeList3) {
				
				if(employee.getEmpAddress().equals(empAddress)) {
					System.out.println(employee);
				}
			}
			
		};
		biConsumer.accept(empList, "Gachibowli");
		
		System.out.println("=================================");
		//print maximum salary in the employeeList
		
		Function<List<Employee>, Double> function=(employeeList1->{
			
			double maxSalary=0;
			for(Employee employee:employeeList1) {
				if(employee.getEmpSalary()>maxSalary) {
					maxSalary=employee.getEmpSalary();
				}
			}
			return maxSalary;
		});
		
		double employeeMaxSalary=function.apply(empList);
		System.out.println(employeeMaxSalary);
		System.out.println("=======================================");
	
		//print maximum salary Employee Details
		
		Function<List<Employee>, Employee> funtion2=(employeeList2->{
			
			double maxSalary=0;
			Employee emp=null;
			
			for(Employee employee:employeeList2) {
				
				if(employee.getEmpSalary()>maxSalary) {
					maxSalary=employee.getEmpSalary();
				}
			}
			
			for(Employee employee:employeeList2) {
				if(employee.getEmpSalary()==maxSalary) {
					emp=employee;
				}
				
			}
			return emp;
		});
		
		Employee empObject=funtion2.apply(empList);
		System.out.println(empObject);
		

}
}