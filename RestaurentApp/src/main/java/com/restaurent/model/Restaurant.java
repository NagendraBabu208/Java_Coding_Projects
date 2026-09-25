package com.restaurent.model;

public class Restaurant {
	private Integer restaurantId;
	private String restaurantName;
	
	private double costForTwo;
	private String cuisine;
	private String type;
	private int ratings;
	private String city;
	
	public Restaurant() {
		
	}

	public Restaurant(Integer restaurantId,String restaurantName,  double costForTwo, String cuisine, String type,
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

	@Override
	public String toString() {
		return "Restaurant [restaurantName=" + restaurantName + ", restaurantId=" + restaurantId + ", castForTwo="
				+ costForTwo + ", cuisine=" + cuisine + ", type=" + type + ", ratings=" + ratings + ", city=" + city
				+ "]";
	}
	
	


}
