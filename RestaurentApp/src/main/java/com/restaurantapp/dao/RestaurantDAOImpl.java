package com.restaurantapp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.restaurantapp.util.Queries;
import com.restaurantapp.util.RestaurantConnect;
import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;

public class RestaurantDAOImpl implements IRestaurantDAO {
	

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		Connection connection=RestaurantConnect.getConnection();
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.INSERTQUERY);){

		    preparedStatement.setInt(1, restaurant.getRestaurantId());
			preparedStatement.setString(2, restaurant.getRestaurantName());
			preparedStatement.setDouble(3, restaurant.getCostForTwo());
			preparedStatement.setString(4, restaurant.getCuisine());
			preparedStatement.setString(5, restaurant.getType());
			preparedStatement.setInt(6, restaurant.getRatings());
			preparedStatement.setString(7, restaurant.getCity());
			//convert LocalTime to Time of DB
			preparedStatement.setObject(8, restaurant.getRestaurantOpeningTime());
			preparedStatement.setObject(9, restaurant.getRestaurantClosingTime());
			
			int updateCount =preparedStatement.executeUpdate();
			System.out.println("Restaurant is successfully added!!!."+updateCount);
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		
		}
		
		
	}
		
	

	@Override
	public void updateRestaurant(int restaurantId, double cost) {
	
		Connection connection=RestaurantConnect.getConnection();
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.UPDATEQUERY);){
			preparedStatement.setDouble(1, cost);
			preparedStatement.setInt(2, restaurantId);
			
		  int updateNoOfRows=preparedStatement.executeUpdate();
			System.out.println("Restaurant is updated!!. "+updateNoOfRows);
		} catch (SQLException sqlException) {
			sqlException.getMessage();
		}
		
	}

	@Override
	public Restaurant findById(int restaurantId) {
		Connection connection=RestaurantConnect.getConnection();
		Restaurant restaurant=null;
	try(	PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTQUERTBYRESTAURANTID);){
			preparedStatement.setInt(1, restaurantId);
		ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int restaId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				LocalTime openingTime=resultSet.getObject(8, LocalTime.class);
				LocalTime closingTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(city);
				restaurant.setRestaurantOpeningTime(openingTime);
				restaurant.setRestaurantClosingTime(closingTime);
				
				}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}
		
		return restaurant;
		
	}

	@Override
	public int deleteRestaurant(int restaurantId) {
		Connection connection=RestaurantConnect.getConnection();
		int deletedRowsNumber=0;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.DELETEQUERY);){
			preparedStatement.setInt(1, restaurantId);
			 deletedRowsNumber=preparedStatement.executeUpdate();
			} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		
		}
		return deletedRowsNumber;
		
	}

	@Override
	public List<Restaurant> findAllRestaurants() {
		   
		   Connection connection=RestaurantConnect.getConnection();
		  List<Restaurant> listOfRestauants=new ArrayList<Restaurant>();
		   Restaurant restaurant=null;
		   try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTQUERY);) {
			  ResultSet resultSet= preparedStatement.executeQuery();
			 
			  while (resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(city);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestauants.add(restaurant);
				
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		  
			return listOfRestauants;
		
	}

	@Override
	public List<Restaurant> findByCuisineLesserCost(Cuisine cuisine, double cost) {
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTBYCUISINELESSERTHANCOST);){
			preparedStatement.setString(1, cuisine.getCuisineType());
			preparedStatement.setDouble(2, cost);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(city);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
	}

	

	@Override
	public List<Restaurant> findByTypeLesserCost(String restaurantType, double cost) {
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTTYPELESSERTHENCOSTQUERY);){
			preparedStatement.setString(1, restaurantType);
			preparedStatement.setDouble(2, cost);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(city);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
		
		
	}

	@Override
	public List<Restaurant> findByTime(LocalDateTime availabiltyTime) {
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTBYTIME);){
			preparedStatement.setObject(1, availabiltyTime.toLocalTime());
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String ncity = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(ncity);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
	}

	@Override
	public List<Restaurant> findByRatingsAndType(String restaurantType, int ratings) {
		
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTBYTYPEANDRATINGSQUERY);){
			preparedStatement.setString(1, restaurantType);
			preparedStatement.setInt(2, ratings);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String ncity = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(ncity);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
	
	}

	@Override
	public List<Restaurant> findByCity(String city) {
		
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTBYCITY);){
			preparedStatement.setString(1, city);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String ncity = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(ncity);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
	}



	@Override
	public List<Restaurant> findByTypelesserCost(double cost) {
		
		Connection connection=RestaurantConnect.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		Restaurant restaurant=null;
		try(PreparedStatement preparedStatement=connection.prepareStatement(Queries.SELECTBYCOST);){
			preparedStatement.setDouble(1, cost);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String nrestaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String ncity = resultSet.getString(7);
				LocalTime opentime=resultSet.getObject(8, LocalTime.class);
				LocalTime closedTime=resultSet.getObject(9, LocalTime.class);
				
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(nrestaurantType);
				restaurant.setCity(ncity);
				restaurant.setRestaurantOpeningTime(opentime);
				restaurant.setRestaurantClosingTime(closedTime);
				
				listOfRestaurants.add(restaurant);
				
			}
			
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
		 return listOfRestaurants;
		
		
	}
	



}
