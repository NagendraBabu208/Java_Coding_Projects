package com.inher.quest4;

public class SMSCommunication extends Communication {

	@Override
	public void sendMessage() {
		System.out.println("Communication through short messaging");
	}
	
	public void messageLength() {
		System.out.println("short messages upto 160 characters ");
	}
	

}
