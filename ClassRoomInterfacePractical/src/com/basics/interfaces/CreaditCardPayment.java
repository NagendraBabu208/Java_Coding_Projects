package com.basics.interfaces;

public class CreaditCardPayment extends CardPayment{

	@Override
	public void payAmount(double amount) {
		System.out.println("Paying amount using Credit card"+amount);
		
	}
	
	void cardLimit(double amount) {
		System.out.println("Limit amount is::"+amount);
	}

}
