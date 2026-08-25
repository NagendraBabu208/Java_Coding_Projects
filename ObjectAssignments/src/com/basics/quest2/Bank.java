package com.basics.quest2;

public class Bank {
	
	private  double balance;
	
	public Bank(double balance) {
		this.balance=balance;
		
	}
	
	public void withdrawAmount(double amount) {
		if(amount<=0) {
			System.out.println(" Invalid withdraw amount");
		}
	     else if(balance<amount) {
			System.out.println(" Insufficient balance ");
		}
		else {
			balance=balance-amount;
			System.out.println(" withdraw amount:: "+amount);
			System.out.println(" After deduct "+amount +" from your Account the available balance is:: "+balance);
		}
	}
	
	public void depositeAmount(double amount) {
		if(amount<0 ||amount==0) {
			System.out.println(" deposit amount must be positive :: "+amount);
		}
		else {
			balance=balance+amount;
			System.out.println("The amount is credited to your Account:: "+amount);
			System.out.println("After amount "+amount+" credited to your Account the available balance is:: "+balance);
			
		}
		
	
	}
	
	public double getBalancce() {
		return balance;
	}

}
