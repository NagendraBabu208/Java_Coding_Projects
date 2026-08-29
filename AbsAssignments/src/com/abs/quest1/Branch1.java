package com.abs.quest1;

public class Branch1  extends Bank{

	@Override
    public void carLoan() {
		System.out.println(" Car Loan provided by Branch1::");
		
	}

	@Override
	public void houseLoan() {
		System.out.println(" House Loan provided by Branch1::");
		
	}

	@Override
	public void educationLoan() {
		System.out.println(" Education Loan provided by Branch1::");
		
}
	public String[] depositeTypes() {
		return new String[] {"PhonePay","GooglePay"};
		
	}

}
