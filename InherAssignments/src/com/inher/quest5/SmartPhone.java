package com.inher.quest5;

public class SmartPhone extends Mobile {

	@Override
	public void call() {
		System.out.println("Smart Phone-call");

	}
	public String[] apps() {
		return new String[] {"whatsApp","Face book","Messanger"};
	}
	
	

}
