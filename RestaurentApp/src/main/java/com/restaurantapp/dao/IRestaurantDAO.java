package com.restaurantapp.dao;

import java.sql.Connection;

public interface IRestaurantDAO {
	
	public  Connection getConnection();
	public  void closeConnection();
		
	

}
