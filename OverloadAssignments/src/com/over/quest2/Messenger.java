package com.over.quest2;

public class Messenger {
	
	public void sendMail(String message) {
		System.out.println(" one-org");
		System.out.println("Hello "+message);
		
	}
	
	public void sendMail(String touserName,String message) {
		System.out.println(" two-org");
		System.out.println("Touser Name ::"+touserName);
		System.out.println(message);
	}
	
	public void sendMail(String touserName, String message,String subject) {
		System.out.println(" three-org");
		System.out.println("Touser Name ::"+touserName);
		System.out.println(message);
		System.out.println(subject);
	}

}
