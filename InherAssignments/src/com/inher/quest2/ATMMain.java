package com.inher.quest2;

import java.util.Scanner;

public class ATMMain {
	public static void main(String[] args) {

		Account account=null;
		Scanner scanner= new Scanner(System.in);
		boolean isATMWorking=true;
		
		while(isATMWorking) {
			System.out.println("enter the account type like Saving/current ::");
			String accountType=scanner.nextLine();
			
			if("SAVING".equals(accountType.toUpperCase())) {
				account=new SavingAccount(100000);
			}else if("CURRENT".equals(accountType.toUpperCase())) {
				account=new CurrentAccount(50000);
			}else {
				System.out.println("Invalid Account Type:: ");
				continue;
			}
			
			boolean isAccountActive=true;
			while(isAccountActive) {
				System.out.println("please choose options like withdraw/deposit/balance/exit:: ");
				String userInput=scanner.nextLine();
				
				switch(userInput.toUpperCase()) {
				case "WITHDRAW":
					System.out.println(" enter the amount to withdraw from your Account:: ");
					double withdrawAmount=scanner.nextDouble();
					account.withdraw(withdrawAmount);
					scanner.nextLine();
					break;
				case "DEPOSIT":
					System.out.println(" enter the amount to deposit to your Account:: ");
					double depositAmount=scanner.nextDouble();
					account.deposite(depositAmount);
					scanner.nextLine();
					break;
				case "BALANCE":
					double balance=account.getBalance();
					System.out.println(" Available balance is:: "+balance);
					scanner.nextLine();
					break;
				case "EXIT":
					System.out.println("Thanks for using ATM. See you again!!!");
					return;
					default:
						System.out.println(" selected invalid operation");
					
				}
			}
		}
		
		if(scanner!=null) {
			scanner.close();
		}
		

	}

}
