package com.abs.quest1;

public  abstract class Branch2 extends Bank{

	@Override
	public void houseLoan() {
		System.out.println(" House Loan Provided by Branch2 ::");
		
	}

	@Override
	public void educationLoan() {
		System.out.println(" Education loan provided by Branch2:: ");
		
		}
	
	public String[] loanTypes() {
		return new String[] {"Car Loan","House Loan","Education Loan"};
		
	}

}
