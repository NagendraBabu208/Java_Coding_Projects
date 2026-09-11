package com.userapp.client;

import java.util.Scanner;

import com.userapp.exception.NameExistsException;
import com.userapp.exception.TooLongException;
import com.userapp.exception.TooShortException;
import com.userapp.service.IValidationService;
import com.userapp.service.ValidationServiceImpl;

public class Registration {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User Name:- ");
		String userName=scanner.nextLine();
		
		boolean flag=false;
	
		
		IValidationService validationService=new ValidationServiceImpl();
		
		try {
			boolean value=validationService.validateUserName(userName);
			
			try {
				if(value) {
					System.out.println("Enter Password:- ");
					String password=scanner.nextLine();
					 flag=validationService.validatePassword(password);
					
				}
			} catch (TooShortException tooShortException) {
				System.out.println(tooShortException.getMessage());
			}
			 catch (TooLongException tooLongException) {
				System.out.println(tooLongException.getMessage());
				
			}
		} catch (NameExistsException nameExistsException ) {
			System.out.println(nameExistsException.getMessage());
		}
		
		
		if(flag) {
			System.out.println("Welcome "+userName+" Your are Registered!!!");
		
		
		if(scanner!=null) {
			scanner.close();
			
		}
		
		
		
	}

	}
	}
