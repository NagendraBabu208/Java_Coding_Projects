package com.restaurantapp.dao;


import java.time.LocalDateTime;

import java.util.List;

import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;

public interface IRestaurantDAO {


	void addRestaurant(Restaurant restaurant);
	void updateRestaurant(int restaurantId,double cost);
	  Restaurant findById(int restaurantId);
	  int deleteRestaurant(int restaurantId);
	  List<Restaurant> findAllRestaurants();
	  List<Restaurant> findByTypelesserCost(double cost);
	  List<Restaurant> findByCuisineLesserCost(Cuisine cuisine,double cost);
	 
	    // find by type , lessercost
	  List<Restaurant> findByTypeLesserCost(String restaurantType, double cost);
	 // find the restaurants by Time
	 List<Restaurant> findByTime(LocalDateTime availabiltyTime);
	  // find by type , high ratings
	  List<Restaurant> findByRatingsAndType(String restaurantType, int ratings);
	 // find by city
	  List<Restaurant> findByCity(String city);

	

}
