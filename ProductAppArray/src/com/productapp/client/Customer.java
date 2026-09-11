package com.productapp.client;

import com.productapp.exception.ProductNotFoundFoundException;
import com.productapp.model.Product;
import com.productapp.service.IProductService;
import com.productapp.service.ProductServiceImpl;

public class Customer {
	
	public static void main(String[] args) {
		
		IProductService productService=new ProductServiceImpl();
		Product[] products=productService.getAllProducts();
		
		for(Product prod:products) {
			System.out.println(prod);
		}
		System.out.println("=======================================================");
		try {
			Product product=productService.getByProductId(6);
			System.out.println(product);
		} catch (ProductNotFoundFoundException productNotFoundFoundException) {
			System.out.println(productNotFoundFoundException.getMessage());
			
		}catch (Exception unknowException) {
				System.out.println(unknowException.getMessage());
				
			}
		System.out.println("========================================================");
		
		try {
			Product[] brandProducts=productService.getProductsByBrand("Samsung");
			for(Product brandProduct:brandProducts) {
				System.out.println(brandProduct);
			}
		} catch (ProductNotFoundFoundException productNotFoundFoundException) {
			System.out.println(productNotFoundFoundException.getMessage());
			
		}catch (Exception unknowException) {
			System.out.println(unknowException.getMessage());
			
		}
	}

}
