package com.predicate.quest2;

import java.util.Arrays;
import java.util.List;

public class ProductPredicateMain {
	
	public static void main(String[] args) {
		
		List<Product> productsList=Arrays.asList(
				new Product(1, "TV", 50000),
				new Product(2, "Fridge", 60000),
				new Product(3, "Mixer", 8000),
				new Product(4, "Bike", 100000),
				new Product(5, "Door", 20000)
				);
		
		IProductPredicate predicate=product->product.getPrice()>50000;
		
		for(Product product:productsList) {
			System.out.println(product.getProductName()+"->"+predicate.checkProductPrice(product));
		}
		
	}

}
