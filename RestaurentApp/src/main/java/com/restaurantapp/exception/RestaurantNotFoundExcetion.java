package com.restaurantapp.exception;

public class RestaurantNotFoundExcetion extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RestaurantNotFoundExcetion(String message) {
     super(message);
	}

}
