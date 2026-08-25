package com.oops.basics;

public class Calculator {
	
	public void sum(int[] intArray) {
		
		int sum=0;
		for(int num:intArray) {
			sum=sum+num;
		}
		System.out.println("Sum::"+sum);
	}
	
	public double square(int number) {
		return Math.pow(number, 2);
	}
	
	
	public static void main(String[] args) {
		int[] intArray= {4,5,6,7,1};
		Calculator calculator= new Calculator();
		calculator.sum(intArray);
		System.out.println("=======================");
		double squareRootValue=calculator.square(7);
		System.out.println(squareRootValue);
	}
	
	

}
