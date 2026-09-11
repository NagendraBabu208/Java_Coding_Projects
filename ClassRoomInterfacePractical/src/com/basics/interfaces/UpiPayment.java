package com.basics.interfaces;

public class UpiPayment implements IPaymentProcessor {

	@Override
	public void payAmount(double amount) {
		System.out.println("paying the amount "+amount+" using upi");
		
	}
	
	public void checkOffers() {
		System.out.println("10% discount for each offer");
		
	}
	
	public void upiLimit (double amount) {
		System.out.println("UPI limit is upto:: "+amount);
		
	}
	

	
	

}
