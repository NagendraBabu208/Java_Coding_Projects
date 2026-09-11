package com.basics.interfaces;

public abstract class  CardPayment  implements IPaymentProcessor{

	
	void cardPayment(String type) {
		System.out.println("Card limit is upto"+type);
	}
}