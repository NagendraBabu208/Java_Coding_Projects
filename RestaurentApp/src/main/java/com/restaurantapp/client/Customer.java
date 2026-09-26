package com.restaurantapp.client;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.restaurantapp.exception.RestaurantNotFoundExcetion;
import com.restaurantapp.service.IRestaurantService;
import com.restaurantapp.service.RestaurantServiceImpl;
import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;

public class Customer {

	public static void main(String[] args) {

		IRestaurantService restaurantService=new RestaurantServiceImpl();


		
		  restaurantService.addRestaurant(new
		  Restaurant(6,"Schezwan Fried Rice",950,Cuisine.CH.getCuisineType(),
		  "VEG",5,"Beijing",LocalTime.of(9, 0),LocalTime.of(23, 0)));
		 
		System.out.println("==================================================");
		 restaurantService.updateRestaurant(16, 1000); 
		System.out.println("===================================================");
		restaurantService.getAllRestaurants().forEach(System.out::println);
		System.out.println("===================================================");
		Restaurant restaurant=restaurantService.getById(1);
		System.out.println(restaurant);
		System.out.println("===================================================");
		try {
			int noOfRestaurantDeleted=restaurantService.deleteRestaurant(7);

			System.out.println(" One restaurant is deleted successfully :: "+noOfRestaurantDeleted);
		}catch (RestaurantNotFoundExcetion  restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
		System.out.println("===================================================");
		try {
			List<Restaurant> listOfRestaurants=restaurantService.getByTypeLesserCost("NONVEG", 1000);
			listOfRestaurants.stream().forEach(System.out::println);
		}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}

		System.out.println("=====================================================================");
		try {
			List<Restaurant> listOfRestaurants=restaurantService.getByCuisineLesserCost(Cuisine.SI, 1000);
			listOfRestaurants.stream().forEach(System.out::println);
		}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
		System.out.println("===============================================================");

		try {
			List<Restaurant> listOfRestaurants=restaurantService.getByCity("Hyderabad");
			listOfRestaurants.stream().forEach(System.out::println);
		} catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
		System.out.println("===============================================================");
       try {
		List<Restaurant> listOfRestaurants=restaurantService.getByTypelesserCost(1000);
		listOfRestaurants.stream().forEach(System.out::println);
		}catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
			System.out.println(restaurantNotFoundExcetion.getMessage());
		}
       System.out.println("===================================================================");
       try {
       List<Restaurant> listOfRestaurants=restaurantService.getByRatingsAndType("VEG", 4);
       listOfRestaurants.stream().forEach(System.out::println);
       
       }catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
       
       System.out.println("==============================================================================");
       try {
    	  List<Restaurant> listOfRestaurants= restaurantService.getByTime(LocalDateTime.of(2026, 9, 26, 14, 30, 0));
    	  listOfRestaurants.stream().forEach(System.out::println);
       }catch (RestaurantNotFoundExcetion restaurantNotFoundExcetion) {
		System.out.println(restaurantNotFoundExcetion.getMessage());
	}
       
       
	}}
