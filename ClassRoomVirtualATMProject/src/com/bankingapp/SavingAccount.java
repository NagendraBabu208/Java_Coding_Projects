package com.bankingapp;

public class SavingAccount extends Account {

	public SavingAccount(double balance) {
		super(balance);
		
	}

	@Override
	void withdraw(double amount) {
		try {
		if(amount>balance) {
			throw new IllegalArgumentException("Insufficient Funds!!!");
		}
		if(amount<=0) {
			throw new IllegalArgumentException("Withdraw amount should not be zero or negative numbers");
		}
		balance=balance-amount;
		System.out.println("After withdraw amount "+amount+" the Available balance:: "+balance);
		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
	}

	@Override
	void deposit(double amount) {
		try {
			if(amount<=0) {
				throw new IllegalArgumentException(" Deposit Amount should not be zero or negative amount!!!");
			}
		 balance=balance+amount;
		System.out.println("After deposite amount "+amount+" to savingAccount. the Available balance "+balance);
		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			
		}

	}
	
	public double getBalance() {
		return balance;
		
	}
	
	
	
	
	
	

}
