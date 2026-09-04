package com.bankingapp;

public class Account {

	double balance;
	
	public Account(double balance) {
		this.balance=balance;
		
		
	}
	
	void withdraw(double amount) {
		System.out.println("withdraw amount");
	}
	
	void deposit(double amount) {
		System.out.println("deposite amount");
	}
	
	public double getBalance() {
		return balance;
	}


}
