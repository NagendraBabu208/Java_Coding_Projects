package com.training.scan;

import java.util.Scanner;

public class ScanSum {
	
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the length of the Array :- ");
		int arrLength=scanner.nextInt();
		
		int[] array=new int[arrLength];
		
		for(int i=0;i<array.length;i++) {
			System.out.println("enter the array element ::");
			array[i]=scanner.nextInt();
		}
		
		int sum=0;
		for(int number:array) {
			sum=sum+number;
		}
		
		int avg=sum/array.length;
		
		System.out.println("Sum is ="+sum+"\tAvg "+avg);
		
		if(scanner!=null) {
			scanner.close();
		}
	}

}
