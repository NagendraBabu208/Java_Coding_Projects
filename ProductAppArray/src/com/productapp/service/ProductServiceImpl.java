package com.productapp.service;



import com.productapp.exception.ProductNotFoundFoundException;
import com.productapp.model.Product;

public class ProductServiceImpl implements IProductService {

	@Override
	public Product[] getAllProducts() {
		Product[] products=showProducts();
		return products;
	}

	@Override
	public Product getByProductId(int productId) throws ProductNotFoundFoundException {
		Product[] products=showProducts();
		Product product=null;
		
		for(Product prod:products) {
			int productIdValue=prod.getProductId();
			if(productIdValue==productId) {
				product=prod;
			}
		}
		//checking product is available or not.
		//If product not available throw ProductNotFoundException
		
		if(product==null) {
			throw new ProductNotFoundFoundException("Product not found with that productId "+productId);
		}
			
		return product;
	}

	@Override
	public Product[] getProductsByBrand(String brand)throws ProductNotFoundFoundException {
		
		Product[] products=showProducts();
		
		int productBrandCount=0; 
		
		//first count the number of brand Products available from Products
		
		for(Product product:products) {
			String productBrand=product.getBrand();
			if(productBrand.equals(brand)) {
				productBrandCount++;
			}
		}
		
		if(productBrandCount==0) {
			throw new ProductNotFoundFoundException("Products not available with that product brand "+brand);

		}
		
		Product[] brandsArray=new Product[productBrandCount];
		
		int index=0;
		//adding products into brandsArray if product brand is available
		for(Product product:products) {
			String productBrand=product.getBrand();
			if(productBrand.equals(brand)) {
				brandsArray[index]=product;
				index++;
				
			}
			
		}
		
		return brandsArray;
	}
	
	public  Product[] showProducts() {
		
		Product[] productsArray= new Product[] {
				new Product("Mobile", 20000, 1,"Nokia"),
				new Product("TV", 50000, 2,"LG"),
				new Product("Fridge", 25000, 3,"Samsung"),
				new Product("AC", 30000, 4,"Samsung"),
				new Product("Washing Machine", 20000, 5,"LG"),
				new Product("Pen", 200, 6,"Cello")
				};
		return productsArray;
		
	}
	
	

}
