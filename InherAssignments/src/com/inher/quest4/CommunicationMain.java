package com.inher.quest4;

import java.util.Scanner;

public class CommunicationMain {
	public static void main(String[] args) {
		Communication communication=null;
		Scanner scanner= new Scanner(System.in);
		boolean isCommunicationOpen=true;
		while(isCommunicationOpen) {
			System.out.println("enter way of Communication(Mail/SMS/Phone/whatsapp) with us after communication completed use Exit ");
			String communicationType=scanner.nextLine();
			
			switch(communicationType.toUpperCase()) {
			case"MAIL":
				communication=new MailCommunication();
				communication.sendMessage();
				MailCommunication mailCommunication=(MailCommunication) communication;
				String[] communicationModes=mailCommunication.showTypes();
				for(String communicationMode:communicationModes) {
					
					System.out.println(communicationMode);
				}
				break;
				
			case "SMS":
				communication= new SMSCommunication();
				communication.sendMessage();
				
				SMSCommunication smsCommunication=(SMSCommunication) communication;
				smsCommunication.messageLength();
				break;
			case "PHONE":
				communication=new PhoneCommunication();
				communication.sendMessage();
				PhoneCommunication phoneCommunication=(PhoneCommunication) communication;
				phoneCommunication.callService();
				break;
			case"WHATSAPP":
				communication= new WhatsappCommunication();
				communication.sendMessage();
				WhatsappCommunication whatsappCommunication=(WhatsappCommunication) communication;
				whatsappCommunication.otherFeatures(); 
				break;
			case"EXIT":
				System.out.println("Thanks for selecting way of your communication.. See you Again.");
				return;
			default:
				System.out.println("Invalid Communication type:: ");
			}
			
			
		}
		
	}

}
