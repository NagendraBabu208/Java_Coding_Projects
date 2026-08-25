package com.oops.basics;

public class Product {
	
	
	public String[] showProducts() {
		String[] productsArray= {"Laptop","TV","Mobile"};
		return productsArray;
 	}
	
	public void printCategories(String[] categories) {

		for(String category:categories ) {
			System.out.println(category);
		}
	}
	
	 public String offerDetails() {
		return "Onam Offers Available";
	}
	
	public static void main(String[] args) {
		Product product= new Product();
		String[] products=product.showProducts();
		String message=product.offerDetails();
		System.out.println(message);
		
		for(String item:products) {
			
			System.out.println(item);
			
		}
		
		product.printCategories(new String[] {"Java","Spring","JDBC"});
	}

}
