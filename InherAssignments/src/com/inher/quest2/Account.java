package com.inher.quest2;

public class Account {
	
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amount) {
		System.out.println("withdraw amount from your Account::");
		
	}
	
	public void deposite(double amount) {
		System.out.println(" amount will be deposite to your Account::");
		
	}
	
	public double getBalance() {
		return balance;
		
	}
	
	

}
