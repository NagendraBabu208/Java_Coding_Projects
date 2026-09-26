package com.restaurantapp.service;


import java.time.LocalDateTime;

import java.util.List;

import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;


public interface IRestaurantService {
	
	void addRestaurant(Restaurant restaurant);
	void updateRestaurant(int restaurantId,double cost);
	  Restaurant getById(int restaurantId);
	  int deleteRestaurant(int restaurantId);
	  List<Restaurant> getAllRestaurants();
	  List<Restaurant> getByCuisineLesserCost(Cuisine cuisine,double cost);
	  List<Restaurant> getByTypelesserCost(double cost);
	    // get by type , lessercost
	  List<Restaurant> getByTypeLesserCost(String restaurantType, double cost);
	 // get the restaurants by Time
	 List<Restaurant> getByTime(LocalDateTime availabiltyTime);
	  // get by type , high ratings
	  List<Restaurant> getByRatingsAndType(String restaurantType, int ratings);
	 // get by city
	  List<Restaurant> getByCity(String city);

}
