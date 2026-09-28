package com.restaurantapp.service;




import java.time.LocalDateTime;

import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import com.restaurantapp.dao.IRestaurantDAO;
import com.restaurantapp.dao.RestaurantDAOImpl;
import com.restaurantapp.exception.RestaurantNotFoundExcetion;

import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;
import com.restaurent.model.RestaurantType;

public class RestaurantServiceImpl implements IRestaurantService {
    private IRestaurantDAO restaurantDAO =new RestaurantDAOImpl();
	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantDAO.addRestaurant(restaurant);

		
	}

	@Override
	public void updateRestaurant(int restaurantId, double cost) {
		restaurantDAO.updateRestaurant(restaurantId, cost);
		
	}

	@Override
	public Restaurant getById(int restaurantId) {
		Restaurant restaurant=restaurantDAO.findById(restaurantId);
		if(restaurant==null) {
			throw new RestaurantNotFoundExcetion("Restaurant is not found!!!");
		}
		return restaurant;
	}

	@Override
	public void deleteRestaurant(int restaurantId) { 
		restaurantDAO.deleteRestaurant(restaurantId);
	
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> listRestaurants=restaurantDAO.findAllRestaurants();
		if(listRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");
		}
		//sort by name, change the name to Upper case and print it
		List<Restaurant> listofRestaurants=listRestaurants
		.stream()
		.sorted(Comparator.comparing(Restaurant::getRestaurantName))
		.map(restaurant->{
			restaurant.setRestaurantName(restaurant.getRestaurantName().toUpperCase());
			return restaurant;
		})
		.collect(Collectors.toList());
		
		return listofRestaurants ;
	}

	@Override
	public List<Restaurant> getByCuisineLesserCost(Cuisine cuisine, double cost) {
		List<Restaurant> listOfRestaurants=restaurantDAO.findByCuisineLesserCost(cuisine, cost);
		
        if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");
		}
        
        List<Restaurant> listOfRestaurantsSortedByName =listOfRestaurants.stream()
        .sorted(Comparator.comparing(Restaurant::getRestaurantName))
        .map(restaurant->{
        	restaurant.setRestaurantName(restaurant.getRestaurantName().toUpperCase());
        	return restaurant;
        }).collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}

	@Override
	public List<Restaurant> getByTypelesserCost(double cost) {
		List<Restaurant> listOfRestaurants=restaurantDAO.findByTypelesserCost(cost);
		
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");	
		}
		
		List<Restaurant> listOfRestaurantsSortedByName=listOfRestaurants.stream()
		.sorted(Comparator.comparing(Restaurant::getRestaurantName))
		.collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}

	@Override
	public List<Restaurant> getByTypeLesserCost(String restaurantType, double cost) {
		
		List<Restaurant> listOfRestaurants=restaurantDAO.findByTypeLesserCost(restaurantType, cost);
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");
			
			}
		
		List<Restaurant> listOfRestaurantsSortedByName=listOfRestaurants.stream()
				.sorted(Comparator.comparing(Restaurant::getRestaurantName))
				.collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}

	@Override
	public List<Restaurant> getByTime(LocalDateTime availabiltyTime) {
	   List<Restaurant> listOfRestaurants=restaurantDAO.findByTime(availabiltyTime);
	   
	   if(listOfRestaurants.isEmpty()) {
		   throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");  
	   }
	   
	   List<Restaurant> listOfRestaurantsSortedByName=listOfRestaurants.stream()
				.sorted(Comparator.comparing(Restaurant::getRestaurantName))
				.collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}

	@Override
	public List<Restaurant> getByRatingsAndType(String restaurantType, int ratings) {
		
		List<Restaurant> listOfRestaurants=restaurantDAO.findByRatingsAndType(restaurantType, ratings);
		
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");
		}
		
		List<Restaurant> listOfRestaurantsSortedByName=listOfRestaurants.stream()
				.sorted(Comparator.comparing(Restaurant::getRestaurantName))
				.collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}

	@Override
	public List<Restaurant> getByCity(String city) {
		List<Restaurant> listOfRestaurants=restaurantDAO.findByCity(city);
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants are not available!!!");
		}
		List<Restaurant> listOfRestaurantsSortedByName=listOfRestaurants.stream()
				.sorted(Comparator.comparing(Restaurant::getRestaurantName))
				.collect(Collectors.toList());
		
		return listOfRestaurantsSortedByName;
	}
	


}
