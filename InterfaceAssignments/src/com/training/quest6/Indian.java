package com.training.quest6;

public class Indian implements ICuisine {

	@Override
	public String[] showMenu(String type) {
		String[] menu=null;
		
		if("STARTERS".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Paneer Tikka"};
			
		}
		else if("DESSERTS".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Gulab Jamun"};
		}
		else if("MainCourse".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Butter Chicken","Butter Naan","Jeera Rice"};
		}
		else {
			menu = new String[] {"Invalid input Type!!"};
			
		}
		
		return menu;
	}

}
