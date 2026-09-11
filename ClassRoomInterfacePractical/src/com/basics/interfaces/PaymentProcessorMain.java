package com.basics.interfaces;

public class PaymentProcessorMain {
	
	public static void main(String[] args) {
		
		IPaymentProcessor paymentProcessor=new UpiPayment();
		paymentProcessor.payAmount(1000);
		paymentProcessor.checkOffers();//default method
		IPaymentProcessor.printReceipt();
		UpiPayment upiPayment=(UpiPayment) paymentProcessor;
		upiPayment.upiLimit(10000);
		
		
		
	 paymentProcessor=new CreaditCardPayment();
	 paymentProcessor.payAmount(500);
	CreaditCardPayment creaditCardPayment=(CreaditCardPayment) paymentProcessor;
	creaditCardPayment.cardLimit(10000);
	
	
	paymentProcessor=new DebitCardPayment();
	paymentProcessor.checkOffers();
	paymentProcessor.payAmount(2000);
	
	
	DebitCardPayment debitCardPayment=new DebitCardPayment();
	debitCardPayment.cardLimit(100000);
	
	
	}

}
