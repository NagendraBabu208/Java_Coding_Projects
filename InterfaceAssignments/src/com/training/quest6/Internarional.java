package com.training.quest6;

public class Internarional implements ICuisine {

	@Override
	public String[] showMenu(String type) {
		String[] menu=null;
		
		if("STARTERS".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Gyoza","French Onionn Soup"};
			
		}
		else if("DESSERTS".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Mochi","Tiramisu"};
		}
		else if("MainCourse".equalsIgnoreCase(type.toUpperCase())) {
			menu=new String[] {"Lasanga","Chicken Enchiladas"};
		}
		else {
			menu = new String[] {"Invalid input Type!!"};
			
		}
		
		return menu;
	}

}
