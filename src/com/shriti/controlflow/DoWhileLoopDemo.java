package com.shriti.controlflow;

public class DoWhileLoopDemo {
	
	public static void main(String[] args) {
		//print numbers 1-10
		int i=0;
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		System.out.println("===============================================");
		//sum of 10 numbers
		int sum=0;
		int num=0;
		do {
			sum=sum+num;
			num++;
			
		}while(num<=10);
		System.out.println("Sum "+sum);
		System.out.println("======================================================");
		//print even numbers between 1-20
		int num2=2;
		do {
		if(num2%2==0) {
			System.out.println(num2);
		}
		num2++;
		}while(num2<=20);
		System.out.println("================================================");
		
		
		//print multiplication table of 5 
		int num3=1;
		do {
			System.out.println(num3+" * 5 = "+(num3*5));
			num3++;
		}while(num3<=20);
	}

}
