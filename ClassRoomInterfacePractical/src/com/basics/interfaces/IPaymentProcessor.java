package com.basics.interfaces;

public interface IPaymentProcessor {
	
	String message="Payment Gateway mode";
	void payAmount(double amount);
	
	static void printReceipt() {
		System.out.println("Printing payment receipt::");
	}
	
	default void checkOffers() {
		System.out.println(" different are Offers provided");
	}

}
