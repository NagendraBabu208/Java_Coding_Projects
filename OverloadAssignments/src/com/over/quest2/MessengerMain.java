package com.over.quest2;

public class MessengerMain {
	public static void main(String[] args) {
		Messenger messenger= new Messenger();
		messenger.sendMail("you got the mail please check it.");
		messenger.sendMail("naga_kumar", "your email is not working!!!");
		messenger.sendMail("nagendra@gmail.com","you got a mail to your mailId","Discussion on project");
	}

}
