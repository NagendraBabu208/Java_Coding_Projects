package com.bankingapp;

public class CurrentAccount extends Account {
	String accountType;
	public CurrentAccount(String accountType,double balance) {
		super(balance);
		this.accountType=accountType;

	}

	@Override
	void withdraw(double amount) {
		try {
			if(amount>balance) {
				throw new IllegalArgumentException("Insufficient Funds!!!");
			}
			if(amount<=0) {
				throw new IllegalArgumentException("Withdraw amount must be greater then the zero or positive values!!!");
			}
		balance=balance-amount-100;
		System.out.println("After withdraw amount "+amount+ " from your current account. the Available balance "+balance);
		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
	}

	@Override
	void deposit(double amount) {
		try {
			if(amount<=0) {
				throw new IllegalArgumentException("Deposit amount must be positive values!!!");
			}
		balance=balance+amount+50;
		System.out.println("After Deposit amount "+amount+" to your currentAccount. the Available Balance "+balance);

		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
	}

	public 	String[] showLoanTypes() {
		return new String[] {"short term","long term", "Vehicle loan"};
	}

	public double getBalance() {
		return balance;
	}

}
