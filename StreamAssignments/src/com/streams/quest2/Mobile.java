package com.streams.quest2;

public class Mobile {
	
	private String model;
	private String brand;
	private double price;
	private Integer mobileId;
	
	public Mobile() {
	}

	public Mobile(String model, String brand, double price, Integer mobileId) {
		super();
		this.model = model;
		this.brand = brand;
		this.price = price;
		this.mobileId = mobileId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	@Override
	public String toString() {
		return "Mobile [model=" + model + ", brand=" + brand + ", price=" + price + ", mobileId=" + mobileId + "]";
	}
	
	
	

}
