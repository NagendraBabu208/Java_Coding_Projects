package com.inher.quest4;

public class MailCommunication extends Communication {

	@Override
	public void sendMessage() {
	System.out.println("Communication using mail service:: ");
	}
	
	public String[] showTypes() {
		return new String[] {"email","telegram","letter"};
	}
	
	

}
