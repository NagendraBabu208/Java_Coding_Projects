package com.training.scan;

import java.util.Scanner;

public class Login {
	
	public static void main(String[] args) {
		String[]  loginUserNamesArray =
			{"jyothi","Gayathri","Nagendra","Vasu","Sudha","Vamsi"};	
		
		Scanner scanner=new Scanner(System.in);
		boolean flag=false;
		System.out.println("enter username to login:: ");
		String userName=scanner.nextLine();
		
		for(int i=0;i<loginUserNamesArray.length;i++) {
			
			if(loginUserNamesArray[i].toLowerCase().equals(userName.toLowerCase())) {
				flag=true;
			}
			
		}
		
		if(flag) {
			System.out.println("\"Your loged in successfully\"");
		}
		else {
			System.out.println("\"Invalid username\" ");
		}
		
		if(scanner!=null) {
			scanner.close();
		}
	}

}
