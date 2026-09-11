package com.productapp.service;


import com.productapp.model.Product;

public interface IProductService {
	
	 Product[] getAllProducts();
	 Product getByProductId(int productId);
	 Product[] getProductsByBrand(String brand);
	 

}
