package com.inher.quest5;

import java.util.Scanner;

public class MobileMain {
	
	public static void main(String[] args) {
		Mobile mobile=null;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter the user which mobile is required(FeaturePhone/SmartPhone)::");
		String userInput=scanner.nextLine();
		
		if("FEATUREPHONE".equalsIgnoreCase(userInput.toUpperCase())) {
			mobile=new FeaturePhone();
			mobile.call();
		}else if("SMARTPHONE".equalsIgnoreCase(userInput.toUpperCase())) {
			mobile=new SmartPhone();
			mobile.call();
			SmartPhone smartPhone=(SmartPhone) mobile;
			String[] apps=smartPhone.apps();
			for(String app:apps) {
				System.out.println(app);
			}
		}
		else {
			System.out.println("Invalid User Input:: ");
		}
		
		if(scanner!=null) {
			scanner.close();
		}
		
	}

}
