package com.training.strings;

import java.util.Scanner;

public class PalindromeString {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the user input string ");
		String userInput=scanner.nextLine();
		
		boolean flag=true;
		
		int start=0;
		int end=userInput.length()-1;
		while(start<end) {
			
			if(userInput.charAt(start)!=userInput.charAt(end)) {
				
				flag=false;
				break;
				}
			
			start++;
			end--;
			
		}
		if(flag) {
			System.out.println(" Given String is palindrome!!! ");
		}else {
			System.out.println(" Given String is not a palindrome!!! ");
		}
		
		
	}

}
