package com.restaurantapp.client;

import java.util.List;

import com.restaurantapp.exception.RestaurantNotFoundExcetion;
import com.restaurantapp.service.IRestaurantService;
import com.restaurantapp.service.RestaurantServiceImpl;
import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;

public class Customer {
	
	public static void main(String[] args) {
		
		IRestaurantService restaurantService=new RestaurantServiceImpl();
		try {
		restaurantService.deleteRestaurant(1);
	}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
		System.out.println("=========================================================================");
		try {
		List<Restaurant> listOfRestaurants=restaurantService.getAllRestaurants();
		listOfRestaurants.stream().forEach(System.out::println);
		}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
			
		}
		System.out.println("==========================================================================");
		restaurantService.addRestaurant( new Restaurant(16,"Udupi Grand",350,"SOUTH INDIAN",
		        "VEG",5,"BANGALORE"));
		
		System.out.println("==========================================================================");
		
		try {
		List<Restaurant> listRestaurants=restaurantService.getByCity("Chennai");
		listRestaurants.stream().forEach(System.out::println);
		}catch (RestaurantNotFoundExcetion  restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
		System.out.println("=================================================================");
		try {
		List<Restaurant> siRestaurantsBasedOnCostAvailable=restaurantService.getByCuisineLesserCost(Cuisine.SI, 500);
		siRestaurantsBasedOnCostAvailable.stream().forEach(System.out::println);
		}catch(RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
		System.out.println("=====================================================================");
	try {
		Restaurant restaurant=restaurantService.getById(2);
		System.out.println(restaurant);
	}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
	
	System.out.println("============================================================");
	try {
	List<Restaurant> listOfRestaurantBasedOnTypeAndRating=restaurantService.getByRatingsAndType("VEG", 4);
	listOfRestaurantBasedOnTypeAndRating.stream().forEach(System.out::println);
	
	}catch(RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
	System.out.println("=====================================================================");
	try {
	List<Restaurant> listOfRestaurantsBasedOnCost=restaurantService.getByTypelesserCost(800);
	listOfRestaurantsBasedOnCost.stream().forEach(System.out::println);
	}catch(RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
	System.out.println("======================================================================");
	
	try {
	List<Restaurant> restaurantsList=restaurantService.getByTypeLesserCost("NONVEG", 1000);
	restaurantsList.stream().forEach(System.out::println);
	}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
	
	}

}
