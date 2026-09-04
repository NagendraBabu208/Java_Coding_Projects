package com.bankingapp;

import java.util.Scanner;

public class BankATMMain {

	public static void main(String[] args) {
		Account account=null;

		Scanner scanner= new Scanner(System.in);
		boolean isBankATMAvailable=true;
		CurrentAccount currentAccount= null;
		while(isBankATMAvailable) {
			System.out.println("Select Account Type - Saving/Current");
			String accountType=scanner.nextLine();

			if("SAVING".equalsIgnoreCase(accountType)) { 
				account=new SavingAccount(10000); 
				
			}else if("CURRENT".equalsIgnoreCase(accountType)){
				account=new CurrentAccount(accountType,10000);
				System.out.println("======================Current Account specific Details=========================");
			    currentAccount=(CurrentAccount) account;
			    String[] loanTypes=currentAccount.showLoanTypes();
				for(String loanType:loanTypes) {
					System.out.println(loanType);
				}
				System.out.println("=============================================================");
			}
			else {
				System.out.println("Invalid Input");
				continue;
			}

			boolean isATMWorking=true;
			while(isATMWorking) {
				System.out.println("Please select Operation to perform- Deposit/Withdraw/Balance/Exit ");
				String operationType=scanner.nextLine();

				switch(operationType.toUpperCase()) {

				case "DEPOSIT":
					System.out.println(" Enter amount to deposit::");
					double depositAmount=scanner.nextDouble();
					account.deposit(depositAmount);
					scanner.nextLine();
					break;
				case "WITHDRAW":
					System.out.println(" Enter amount to withdraw::");
					double withdrawAmountCurrent=scanner.nextDouble();
					account.withdraw(withdrawAmountCurrent);
					scanner.nextLine();
					break;
				case"BALANCE":
					double availableBalance= account.balance;
					System.out.println("Available Balance:: "+availableBalance);
					break;
				case"EXIT":
					System.out.println("Thanks using ATM. See you again!!!");
					return;
				default:
					System.out.println("Invalid Operation Type!!!. Please select correct operation:: ");
					continue;
				}	  
			}

		}
		
		if(scanner!=null) {
			scanner.close();
		}



	}


}
