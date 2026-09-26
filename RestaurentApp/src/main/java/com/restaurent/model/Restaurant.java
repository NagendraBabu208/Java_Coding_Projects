package com.restaurent.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Restaurant {
	private Integer restaurantId;
    private String restaurantName;
	private double costForTwo;
	private String cuisine;
	private String type;
	private int ratings;
	private String city;
	private LocalTime restaurantOpeningTime;
	private LocalTime restaurantClosingTime;
	
	public Restaurant() {
		
	}

	
	public Restaurant(Integer restaurantId, String restaurantName, double costForTwo, String cuisine, String type,
			int ratings, String city) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.costForTwo = costForTwo;
		this.cuisine = cuisine;
		this.type = type;
		this.ratings = ratings;
		this.city = city;
	}
	





	public Restaurant(Integer restaurantId, String restaurantName, double costForTwo, String cuisine, String type,
			int ratings, String city, LocalTime restaurantOpeningTime, LocalTime restaurantClosingTime) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.costForTwo = costForTwo;
		this.cuisine = cuisine;
		this.type = type;
		this.ratings = ratings;
		this.city = city;
		this.restaurantOpeningTime = restaurantOpeningTime;
		this.restaurantClosingTime = restaurantClosingTime;
	}


	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getCostForTwo() {
		return costForTwo;
	}

	public void setCastForTwo(double costForTwo) {
		this.costForTwo = costForTwo;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}





	public LocalTime getRestaurantOpeningTime() {
		return restaurantOpeningTime;
	}


	public void setRestaurantOpeningTime(LocalTime restaurantOpeningTime) {
		this.restaurantOpeningTime = restaurantOpeningTime;
	}


	public LocalTime getRestaurantClosingTime() {
		return restaurantClosingTime;
	}


	public void setRestaurantClosingTime(LocalTime restaurantClosingTime) {
		this.restaurantClosingTime = restaurantClosingTime;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", costForTwo="
				+ costForTwo + ", cuisine=" + cuisine + ", type=" + type + ", ratings=" + ratings + ", city=" + city
				+ ", restaurantOpeningTime=" + restaurantOpeningTime + ", restaurantClosingTime="
				+ restaurantClosingTime + "]";
	}

  	
	
	

	
	


}
