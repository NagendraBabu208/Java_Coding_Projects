package com.sbi.main;

import java.util.Scanner;

import com.sbi.service.SBIATMService;

public class SBIATMMain {
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		SBIATMService sbiATMService=new SBIATMService();
		boolean isATMWorking=true;
		System.out.println("Welcome to the SBI ATM Center. Please insert your ATM Card!!!");
		
		while(isATMWorking) {
			System.out.println("Please select the option (Deposit/withdraw/change PIN/Balance/Account Details/Exit) ");
			String atmOptionType=scanner.nextLine();
			
			switch(atmOptionType.toUpperCase()) {
			case "BALANCE":
				System.out.println("Please enter the Pin Number ");
				String cardPinNumber=scanner.nextLine();
				double availableBalance=sbiATMService.checkBalance(cardPinNumber);
				System.out.println("Available balance is :- "+availableBalance);
				
				break;
			case "CHANGE PIN":
				System.out.println("Please enter the Pin Number ");
	            String pinNumber=scanner.nextLine();
	            System.out.println("Please enter the Updated Pin Number!!!");
	            String updatedPinNumber=scanner.nextLine();
	            sbiATMService.changePinNumber(pinNumber,updatedPinNumber);
	            break;
			case "ACCOUNT DETAILS":
				System.out.println(" Please enter the Pin Number ");
				String atmPinNumber=scanner.nextLine();
				sbiATMService.displayAccountDetails(atmPinNumber);
				break;
			case "DEPOSIT":
				System.out.println("Please enter the Amount ");
				double depositAmount=scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please enter Account Number!!!");
				long accountNumber=scanner.nextLong();
				scanner.nextLine();
				System.out.println(" Please enter the Pin Number ");
				String pinNum=scanner.nextLine();
				sbiATMService.depositAmount(depositAmount, pinNum, accountNumber);
				break;
			case "WITHDRAW":
				System.out.println("Please enter the Amount to withdraw ");
				double withdrawAmount=scanner.nextDouble();
				scanner.nextLine();
				System.out.println("Please enter pin number ");
				String accountPinNumber=scanner.nextLine();
				sbiATMService.withdrawAmount(withdrawAmount, accountPinNumber);
				break;
			case "EXIT":
				System.out.println("Thanks for visiting SBI ATM!!!. See you Again.");
				return;
				default:
					System.out.println("Invalid Option!!!. Please Select Valid option");
					continue;
			}
			
		}
		
		if(scanner!=null) {
			scanner.close();
		}
	}

}
