package com.shriti.controlflow;

public class IfDemo {
	
	public static void main(String[] args) {
		
		//int number=56;
		int number=33;
		
		if(number%2==0) {
			System.out.println(" given number is Even number ::"+number);
			
		}else {
			System.out.println(" given number is odd number ::"+number);
			
		}
		
		//find largest number among three numbers
		
		int a=20;
		int b=15;
		int c=25;
		
		if(a>b && a>c) {
			System.out.println(" a is greater:: ");
		}
		else if(b>c) {
			System.out.println(" b is greater:: ");

		}
		else {
			System.out.println(" c is greater:: ");

		}
		
		// checking vote eligibility
		// input age and print whether a person is eligible to vote (18+)
		
		int personAge=16;
		
		if(personAge>18) {
			System.out.println(" person is eligible to cast their vote:: "+personAge);
		}
		else {
			System.out.println(" person is not eligible to cast their vote:: "+ personAge);
		}
	}

}
