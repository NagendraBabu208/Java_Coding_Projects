package com.training.scan;

import java.util.Scanner;

public class NamesRegistration {
	
	public static void main(String[] args) {
		
		String[]  namesArray= {"jyothi","Gayathri","Nagendra","Vasu","Sudha","Vamsi"};
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter name to register:: ");
		
		String userName=scanner.nextLine();
		
		boolean flag=false;
		
		for(int i=0;i<namesArray.length;i++) {
			
			if(namesArray[i].toLowerCase().equals(userName.toLowerCase())) {
				flag=true;
				
			}
			}
		if(flag) {
			System.out.println("\"Name is not unique\"");
		}
		else {
			System.out.println("\"Your are registered\"");
		}
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
