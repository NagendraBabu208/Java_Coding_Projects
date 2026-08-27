package com.inher.quest2;

public class SavingAccount extends Account {

	public SavingAccount(double balance) {
		super(balance);
		System.out.println(" for Saving Account 20 percent interest will be added to your balance ");
		double savingBalance=balance;
		double balanceAfterInterest=savingBalance +(savingBalance*0.2);
		System.out.println(" The Available balance is:: "+balanceAfterInterest);
		}

	@Override
	public void withdraw(double amount) {
	
		if(amount<=0) {
			System.out.println(" Withdraw amount must be positive number:: ");
		}else if(amount>getBalance()) {
			System.out.println("Insufficient funds from your Saving Account");
		}else {
			  double balance=getBalance() +(getBalance()*0.2);
			double savingBalance= balance-amount; 
			System.out.println("Available balance is:: "+savingBalance);
		}
		
	}

	@Override
	public void deposite(double amount) {
	
		 if(amount<=0) {
			 System.out.println("deposite amount should not be negative number:: ");
		 }
		 else {
			 double balance=getBalance() +(getBalance()*0.2);
			 double savingBalance=balance+amount;
			 System.out.println("deposited "+amount+" after Avaliable balance is:: "+savingBalance);
		 }
	
	}

}
