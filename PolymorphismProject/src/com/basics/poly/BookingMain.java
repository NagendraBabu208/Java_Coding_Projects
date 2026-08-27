package com.basics.poly;

public class BookingMain {
	public static void main(String[] args) {
		Booking booking=new Booking();
		booking.ticketBooking("Nagendra", "Koppal", "Guntur");
		System.out.println("=================================================");
		booking.ticketBooking("Nagendra", "Koppal", "Guntur","Phone","waterbottle","charger");
		System.out.println("=================================================");

		booking.ticketBooking("Nagendra", "Koppal", "Guntur",3);
	}

}
