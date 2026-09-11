package com.productapp.model;

public class Product {
	
	private String productName;
	private double price;
	private int productId;
	private String brand;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, double price, int productId, String brand) {
		super();
		this.productName = productName;
		this.price = price;
		this.productId = productId;
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", productId=" + productId + ", brand="
				+ brand + "]";
	}
	
	
	

}
