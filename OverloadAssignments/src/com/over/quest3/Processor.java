package com.over.quest3;

public class Processor {
	
	public void calculate(double value) {
		System.out.println(Math.sqrt(value));
		
	}
	
	public void calculate( int value1, int value2) {
		int product=value1*value2;
		System.out.println(product);
		
	}
	
	public void calculate( double value1, double value2) {
		double difference=value1-value2;
		System.out.println(difference);
		
	}
	
	public void calculate( double value1, int value2) {
		double value=Math.pow(value1, value2);
		System.out.println(value);
		
	}
	
	public void calculate(int value) {
		System.out.println(Math.pow(value, 2));
		
	}
	

}
