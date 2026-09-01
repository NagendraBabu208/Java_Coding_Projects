package com.training.quest5;

import java.util.Scanner;

public class Customer {
	public static void main(String[] args) {
		IFeaturePhone featurePhone=null;
		ISmartPhone smartPhone=null;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter BasicPhone/SmartPhone what you wants ");
		String userInput=scanner.nextLine();
		
		if("BASICPHONE".equalsIgnoreCase(userInput.toUpperCase())) {
			featurePhone=new BasicMobile();
			featurePhone.call();
			featurePhone.messaging();
		
		}else if("SMARTPHONE".equalsIgnoreCase(userInput.toUpperCase())) {
			smartPhone=new TouchScreenMobile();
			smartPhone.call();
			smartPhone.messaging();
			smartPhone.cameraTypes();
			smartPhone.showApps();
			
		}else {
			System.out.println(" Invalid User Input ");
		}
		
	if(scanner!=null) {
		scanner.close();
	}
	}

}
