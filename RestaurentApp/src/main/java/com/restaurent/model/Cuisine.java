package com.restaurent.model;

public enum Cuisine {
	
	SI("SOUTH INDIAN"),
	NI("NORTH INDIAN"),
	IT("ITALIAN"),
	CH("CHINESE"),
	CO("CONTINENTAL");
	
	
	private String cuisineType;
	
	private Cuisine(String type) {
		this.cuisineType=type;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	
	
	
	

}
