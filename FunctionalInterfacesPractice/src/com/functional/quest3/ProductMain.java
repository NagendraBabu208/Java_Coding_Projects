package com.functional.quest3;

public class ProductMain {
	
	public static void main(String[] args) {
		
		Product[] productArray=new Product[] {
				new Product(1, "TV", 25000),
				new Product(2, "Bat", 10000),
				new Product(3, "Book", 250),
				new Product(4, "Bike", 100000),
				new Product(5, "Washing Machine", 25000),
				
		};
		
		IProductFunctional functional=product->product.getProductName();
		
		for(Product product:productArray) {
			System.out.println(functional.getProductName(product));
		}
	}

}
