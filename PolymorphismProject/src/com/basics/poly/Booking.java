package com.basics.poly;

public class Booking {
	
	public void ticketBooking(String passenger,String source,String destination){
		System.out.println("Passenger Name "+passenger);
		System.out.println("Source place Name :"+source);
		System.out.println("Destination place Name :"+destination);
	}
	
		
	public void ticketBooking(String passenger,String source,String destination,String...extraThings) {
		System.out.println("Passenger Name "+passenger);
		System.out.println("Source place Name :"+source);
		System.out.println("Destination place Name :"+destination);
		for(String thing:extraThings) {
			System.out.println(thing);
		}
	}
	
	public void ticketBooking(String passenger,String source,String destination, int noOfTickets) {
		System.out.println("Passenger Name "+passenger);
		System.out.println("Source place Name :"+source);
		System.out.println("Destination place Name :"+destination);
		System.out.println("Number no of tickets ::"+noOfTickets);
	}
		
	

}
