package com.datetime.practice;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Example01 {
	public static void main(String[] args) {
		
		LocalDate localDate= LocalDate.now();
		System.out.println(localDate);
		System.out.println("======================================");
		LocalDate localDate2=LocalDate.parse("2025-08-15");
		int dayOfMonth=localDate2.getDayOfMonth();
		String monthName=localDate2.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year=localDate2.getYear();
		System.out.println(dayOfMonth+"-"+monthName+"-"+year);
		
		System.out.println("Year::- "+year);
		System.out.println("Month::- "+monthName);
		System.out.println("Day ::- "+dayOfMonth);
		System.out.println(localDate2.getDayOfWeek());
		System.out.println("============================================");
	
		LocalDate localDate3=LocalDate.parse("2025-08-15");
		System.out.println(localDate3.plusMonths(3));
		
		System.out.println(localDate3.minusMonths(2));
		System.out.println(localDate3.plusYears(1));
		System.out.println("=======================================");
		LocalDate firstDate=LocalDate.parse("2025-08-15");
		LocalDate secondDate=LocalDate.parse("2025-12-25");
		
		if(firstDate.isBefore(secondDate)) {
			System.out.println("First date comes before the second date");
		}else if(firstDate.isAfter(secondDate)) {
			System.out.println("First date comes after the second date");

		}else {
			System.out.println("Invalid Dates!!!.");
		}
		

		
		
		
	
	}

}
