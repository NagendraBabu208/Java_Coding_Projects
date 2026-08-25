package com.training.basics;



// find the armstrong number
public class ArmStrong {
	
	public static void main(String[] args) {
		
		int number=153;
		String value=String.valueOf(number);
		String[] strArray=value.split("");
		int numberSize=0;
		
		for(String num:strArray) {
			numberSize++;
			}
		
		int sum=0;
		for(String element:strArray) {
			int num=Integer.parseInt(element);
			int powerOfEachDigit=(int) Math.pow(num, numberSize);
			sum=sum+powerOfEachDigit;
		}
		
		if(number==sum) {
			System.out.println(" Given number is ArmStrong number!!! ");
		}
		else {
			System.out.println(" Given number is not a ArmStrong number!!! ");
		}
		
	}

}
