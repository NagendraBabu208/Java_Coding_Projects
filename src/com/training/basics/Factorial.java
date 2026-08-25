package com.training.basics;
// find factorial number for 1 to n
public class Factorial {
	
	public static void main(String[] args) {
		
		int number=7;
		int sum=1;
		
		for(int i=1; i<=number;i++) {
			sum=sum*i;
		}
		System.out.println("Factorial number:: "+sum);
	}

}
