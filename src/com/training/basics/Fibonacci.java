package com.training.basics;
// Fibonacci Series from 0 to 100
public class Fibonacci {
	
	public static void main(String[] args) {
		
		int a=0;
		int b=1;
		while(a<=100) {
			System.out.print(a+" ");
			int c=a+b;
			a=b;
			b=c;
		}
	}  

}
