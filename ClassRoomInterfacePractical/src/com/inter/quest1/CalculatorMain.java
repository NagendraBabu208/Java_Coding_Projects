package com.inter.quest1;

public class CalculatorMain {
	
	public static void main(String[] args) {
		
		
		ICalculator calculator=(x,y)->{
			int sum=x+y;
			return sum;
		};
		
		System.out.println("Sum = "+calculator.calculate(10, 10));
		
		calculator=(x,y)->{
			return (x-y);
			};
			
			System.out.println("Subtraction ="+calculator.calculate(10, 5));
		calculator =(x,y)->(x*y);
		System.out.println("Multification ="+calculator.calculate(10, 10));
	   calculator=(x,y)->(x/y);
	   System.out.println("Division =" +calculator.calculate(12, 6));
	}
	

}
