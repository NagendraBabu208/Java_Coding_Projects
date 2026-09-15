package com.functional.quest5;


public class ProductMain {
	
	public static void main(String[] args) {
		Product[] productsArray=new Product[] {
				new Product(1, "TV", 60000),
				new Product(2, "Bat", 10000),
				new Product(3, "Book", 250),
				new Product(4, "Bike", 100000),
				new Product(5, "Washing Machine", 25000),
				
		};
		
		IProductFunctional functional=product->product.getPrice()>50000;
		
		for(Product product:productsArray) {
			
			System.out.println(product.getProductName()+"-"+functional.checkProduct(product));
		}
	}

}
