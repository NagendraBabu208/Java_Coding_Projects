package com.training.quest6;

import java.util.Scanner;

public class Restaurant {
	
	public static void main(String[] args) {
		
		ICuisine cuisine=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please select Indian/International food");
		String userInput=scanner.nextLine();
	
		if("INDIAN".equalsIgnoreCase(userInput.toUpperCase())) {
			cuisine=new Indian();
			System.out.println("Please select Starters/disserts/mainCourse ");
			String indianItem=scanner.nextLine();
			String[] indianFoods=cuisine.showMenu(indianItem);
			for(String food:indianFoods) {
				System.out.println(food);
			}
		}
		else {
			cuisine=new Internarional();
			System.out.println("Please select Starters/disserts/mainCourse ");
			String internationalItem=scanner.nextLine();
			String[] internationalFoods=cuisine.showMenu(internationalItem);
			for(String food:internationalFoods) {
				System.out.println(food);
			}

		}
		
		if(scanner!=null) {
			scanner.close();
			
		}
	}

}
