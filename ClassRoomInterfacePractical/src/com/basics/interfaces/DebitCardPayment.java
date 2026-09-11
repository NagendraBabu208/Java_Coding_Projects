package com.basics.interfaces;

public class DebitCardPayment extends CardPayment{

	@Override
	public void payAmount(double amount) {
		System.out.println("Paying amount using debit card"+amount);
		
	}
	
	void cardLimit(double amount) {
		System.out.println("Limit amount is::"+amount);
	}
	
	public void checkOffers() {
		System.out.println("15% discount on each item::");
	}

}
