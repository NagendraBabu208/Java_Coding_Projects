package com.training.map;


import java.util.Arrays;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MapMain {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Map<String, List<String>> statesMap=new LinkedHashMap<>();
		
		List<String> listOfCitiesOfAndhraPradesh=
				Arrays.asList("Visakhapatnam","Vijayawada","Guntur","Nellore","Kurnool",
						"Kakinada","Rajamahendravaram","Kadapa","Mangalagiri-Tadepalli",
						"Tirupati","Anantapuram","Ongole","Dharmavaram","Narasaraopet");
	

		List<String> listOfCitiesOfSikkim = Arrays.asList(
	"Gangtok", "Namchi", "Gyalshing", "Mangan", "Singtam", "Rangpo",
	"Jorethang","Nayabazar","Rhenock");
		
		List<String> listOfCitiesOfTripura = Arrays.asList(
	 "Agartala","Udaipur","Dharmanagar", "Kailashahar",
	 "Belonia","Ambassa","Khowai","Sonamura", "Teliamura");
		
		statesMap.put("AndhraPradesh", listOfCitiesOfAndhraPradesh);
		statesMap.put("Sikkim", listOfCitiesOfSikkim);
		statesMap.put("Tripura", listOfCitiesOfTripura);

		System.out.println("Please enter State name(AndhaPradesh/Sikkim/Tripura) :: ");
		String stateName=scanner.nextLine();
		List<String> listOfCities=statesMap.get(stateName);
		//java8 streams
		System.out.println("========================Cities of "+stateName);
		listOfCities.stream().forEach(System.out::println);
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
