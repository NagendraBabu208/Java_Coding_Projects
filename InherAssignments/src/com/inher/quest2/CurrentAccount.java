package com.inher.quest2;

public class CurrentAccount extends Account {

	public CurrentAccount(double balance) {
		super(balance);
		System.out.println(" No interest on Current Account ");
		System.out.println("the Available balance is:: "+balance);
		
		
	}

	@Override
	public void withdraw(double amount) {
	
		if(amount<=0) {
			System.out.println(" Withdraw amount must be positive number:: ");
		}else if(amount>getBalance()) {
			System.out.println("Insufficient funds from your Current Account");
		}else {
			double currentBalance= getBalance()-amount; 
			System.out.println("Available balance is:: "+currentBalance);
		}
		
	}

	@Override
	public void deposite(double amount) {
	
		 if(amount<=0) {
			 System.out.println("deposite amount should not be negative number:: ");
		 }
		 else {
			 double currentBalance=getBalance()+amount;
			 System.out.println("deposited "+amount+" after Avaliable balance is:: "+currentBalance);
		 }
	
	}


		
	}
	
	


