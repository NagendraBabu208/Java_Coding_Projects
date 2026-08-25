package com.shriti.controlflow;

public class ForLoopDemo {
	
	public static void main(String[] args) {
		//print numbers 1-10
		for(int i=1;i<10;i++) {
			System.out.println(i);
		}
		System.out.println("=============================================");
		//sum of 10 numbers
		int sum=0;
		for(int i=0;i<=10;i++) {
			sum=sum+i;
		}
		System.out.println(" Sum ="+sum);
		System.out.println("===================================================");
		//print even numbers between 1-20
		
		for(int i=2;i<20;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		System.out.println("========================================================");
		//print multiplication table of 5 
		
		for(int i=1; i<=20;i++) {
			System.out.println(i+" * 5 = "+(i*5));
		}
	}

}
