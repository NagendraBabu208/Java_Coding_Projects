package com.functional.quest3;

public class ProductMain2 {
	
	public static void main(String[] args) {
		Product[] productArray=new Product[] {
				new Product(1, "TV", 25000),
				new Product(2, "Bat", 10000),
				new Product(3, "Book", 250),
				new Product(4, "Bike", 100000),
				new Product(5, "Washing Machine", 25000),
				
		};
		
		IProductFunctional1 functional1=product->{
			double productCost=product.getPrice();
			double productDiscount=productCost*0.2;
			double afterDiscountProductCost=productCost-productDiscount;
			
			return afterDiscountProductCost;
		};
		
		for(Product product:productArray) {
			System.out.println(product.getProductName()+" -> "+functional1.calcProductCostAfterDiscount(product));
			System.out.println(product.getPrice());
		}
	}

}
