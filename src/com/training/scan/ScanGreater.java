package com.training.scan;

import java.util.Scanner;

public class ScanGreater {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter value one:: ");
		int number1=scanner.nextInt();
		System.out.println("enter value two:: ");
		int number2=scanner.nextInt();
		System.out.println("enter value three:: ");
		int number3=scanner.nextInt();


		int largeNumber=(number1>number2)?
				((number1>number3)?number1:number3):((number2>number3)?number2:number3);

		System.out.println(" largestNumber "+largeNumber);
		
		if(scanner!=null) {
			scanner.close();
		}
	}

}
