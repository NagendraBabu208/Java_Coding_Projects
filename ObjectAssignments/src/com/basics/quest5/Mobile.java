package com.basics.quest5;

public class Mobile {
	
	private String model;
	private String brand;
	private String color;
	
	public Mobile(String model, String brand, String color) {
		super();
		this.model = model;
		this.brand = brand;
		this.color = color;
	}
	
	public void getMobileDetails() {
		System.out.println(" Mobile model:: "+model);
		System.out.println(" Mobile brand:: "+brand);
		System.out.println(" Mobile colour:: "+color);
	}
	
	public String getBrand() {
		return brand;
	}
	

}
