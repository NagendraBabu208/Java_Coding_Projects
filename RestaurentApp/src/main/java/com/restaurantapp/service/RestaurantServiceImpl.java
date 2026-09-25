package com.restaurantapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.restaurantapp.dao.IRestaurantDAO;
import com.restaurantapp.dao.RestaurantDAOImpl;
import com.restaurantapp.exception.RestaurantNotFoundExcetion;
import com.restaurent.model.Cuisine;
import com.restaurent.model.Restaurant;
import com.restaurent.model.RestaurantType;

public class RestaurantServiceImpl implements IRestaurantService {
	
	private IRestaurantDAO restaurantDAO;
	private PreparedStatement preparedStatement;

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		String insertQuery="Insert into restaurant values(?,?,?,?,?,?,?)";
		
		
		try {
			preparedStatement=connection.prepareStatement(insertQuery);
			
			preparedStatement.setInt(1, restaurant.getRestaurantId());
			preparedStatement.setString(2, restaurant.getRestaurantName());
			preparedStatement.setDouble(3, restaurant.getCostForTwo());
			preparedStatement.setString(4, restaurant.getCuisine());
			preparedStatement.setString(5, restaurant.getType());
			preparedStatement.setInt(6, restaurant.getRatings());
			preparedStatement.setString(7, restaurant.getCity());
			
			boolean value=preparedStatement.execute();
			System.out.println("Restaurant is successfully added!!!."+!value);
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		
		}finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
				
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		
	}

	@Override
	public void updateRestaurant(int restaurantId, double cost) {
		
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		String updateQuery="Update restaurant set cost_For_Two=? where restaurant_Id=?";
		try {
			preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1, cost);
			preparedStatement.setInt(2, restaurantId);
			
			int updatedRestaurantCost=preparedStatement.executeUpdate();
			if(updatedRestaurantCost!=1) {
				throw new RestaurantNotFoundExcetion("Restaurant is not found with restaurant id "+restaurantId);
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
			System.out.println(sqlException2.getMessage());
			}
		}
		
		
		
	}

	@Override
	public Restaurant getById(int restaurantId) {
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		String selectQuery="Select * from restaurant where restaurant_Id=?";
		Restaurant restaurant=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, restaurantId);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int restaId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(city);
				
				
				
			}
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			restaurantDAO.closeConnection();
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
			System.out.println("Restaurant successfully found!!!.");
		}
		if(restaurant==null) {
			throw new RestaurantNotFoundExcetion("Restaurant not found!!!.");
		}
		
		return restaurant;
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		String deleteQuery="Delete from restaurant where restaurant_Id=?";
		
		try {
			preparedStatement=connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, restaurantId);
			
			int deleteRestaurantId=preparedStatement.executeUpdate();
			if(deleteRestaurantId!=1) {
				throw new RestaurantNotFoundExcetion("Restaurant not found with restaurant id::"+restaurantId);
			}
			System.out.println("Restaurant is deleted succssfully with restaurantId:: "+restaurantId);
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
	   restaurantDAO=new RestaurantDAOImpl();
	   Connection connection=restaurantDAO.getConnection();
	   List<Restaurant> listOfRestauants=new ArrayList<Restaurant>();
	   Restaurant restaurant=null;
	   ResultSet resultSet=null;
	   String selectQuery="select * from restaurant";
	   
	   try {
		preparedStatement=connection.prepareStatement(selectQuery);
		resultSet=preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			int restaurantId = resultSet.getInt(1);
			String restaurantName = resultSet.getString(2);
			double restaurantCost = resultSet.getDouble(3);
			String restaurantCuisineType = resultSet.getString(4);
			String restaurantType = resultSet.getString(5);
			int restaurantRatings = resultSet.getInt(6);
			String city = resultSet.getString(7);
			
			restaurant=new Restaurant();
			restaurant.setRestaurantName(restaurantName);
			restaurant.setRestaurantId(restaurantId);
			restaurant.setCastForTwo(restaurantCost);
			restaurant.setCuisine(restaurantCuisineType);
			restaurant.setRatings(restaurantRatings);
			restaurant.setType(restaurantType);
			restaurant.setCity(city);
			
			listOfRestauants.add(restaurant);
			
		}
		
	} catch (SQLException sqlException) {
		System.out.println(sqlException.getMessage());
	}finally {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			restaurantDAO.closeConnection();
		}catch (SQLException sqlException2) {
			System.out.println(sqlException2.getMessage());
		}
	}
	   if(listOfRestauants.isEmpty()) {
		   throw new RestaurantNotFoundExcetion("Restaurants not found!!!");
	   }
		return listOfRestauants;
	}

	@Override
	public List<Restaurant> getByCity(String city) {
		   restaurantDAO=new RestaurantDAOImpl();
		   Connection connection=restaurantDAO.getConnection();
		   List<Restaurant> listOfRestauants=new ArrayList<Restaurant>();
		   Restaurant restaurant=null;
		   ResultSet resultSet=null;
		   String selectQuery="Select * from restaurant where city=?";
		   
		   try {
			preparedStatement=connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, city);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String ncity = resultSet.getString(7);
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(ncity);
				
				listOfRestauants.add(restaurant);
				
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		   if(listOfRestauants.isEmpty()) {
			   throw new RestaurantNotFoundExcetion("Restaurants not found!!!");
		   }
			return listOfRestauants;

	}

	@Override
	public List<Restaurant> getByCuisineLesserCost(Cuisine cuisine, double cost) {
		 restaurantDAO=new RestaurantDAOImpl();
		 Connection connection=restaurantDAO.getConnection();
		 String cuisineType=cuisine.getCuisineType();
		 String sqlQuery="Select * from restaurant where cuisine=? AND cost_For_Two<?";
		 ResultSet resultSet=null;
		 Restaurant restaurant=null;
		 List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>(); 
		 try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, cuisineType);
			preparedStatement.setDouble(2, cost);
			
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);	
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(city);
				
				listOfRestaurants.add(restaurant);
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		 
		 if(listOfRestaurants.isEmpty()) {
			 throw new RestaurantNotFoundExcetion("Cuisines are not available with that price:: "+cost);
		 }
		
		return listOfRestaurants;
	}

	@Override
	public List<Restaurant> getByTypelesserCost(double cost) {
		   restaurantDAO=new RestaurantDAOImpl();
		   Connection connection=restaurantDAO.getConnection();
		   List<Restaurant> listOfRestauants=new ArrayList<Restaurant>();
		   Restaurant restaurant=null;
		   ResultSet resultSet=null;
		   String selectQuery="Select * from restaurant where cost_For_Two<?";
		   
		   try {
			preparedStatement=connection.prepareStatement(selectQuery);
			preparedStatement.setDouble(1, cost);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaurantType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaurantType);
				restaurant.setCity(city);
				
				listOfRestauants.add(restaurant);
				
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		   if(listOfRestauants.isEmpty()) {
			   throw new RestaurantNotFoundExcetion("Restaurants not found!!!");
		   }
			return listOfRestauants;
		
	}

	@Override
	public List<Restaurant> getByTypeLesserCost(String restaurantType, double cost) {
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		String sqlQuery="select *  from restaurant where type=? AND cost_For_Two<?";
		    String type=null;
		    List<Restaurant> listOfRestaurants= new ArrayList<Restaurant>();
		    Restaurant restaurant=null;
		    ResultSet resultSet=null;
		    
		    
		if(RestaurantType.VEG.name().equals(restaurantType)) {
			type=restaurantType;
		}
		if(RestaurantType.NONVEG.name().equals(restaurantType)) {
			type=restaurantType;
		}
		
		try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, type);
			preparedStatement.setDouble(2, cost);
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaType);
				restaurant.setCity(city);
				
				listOfRestaurants.add(restaurant);
			}
			
		} catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				restaurantDAO.closeConnection();
			}catch (SQLException sqlException2) {
			System.out.println(sqlException2.getMessage());
			}
		}
		
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants not available!!!.");
		}
		
		return listOfRestaurants;
	}



	@Override
	public List<Restaurant> getByRatingsAndType(String restaurantType, int ratings) {
		restaurantDAO=new RestaurantDAOImpl();
		Connection connection=restaurantDAO.getConnection();
		List<Restaurant> listOfRestaurants=new ArrayList<Restaurant>();
		String sqlQuery="select * from restaurant where type=? AND ratings=?";
		Restaurant restaurant=null;
		String type=null;
		ResultSet resultSet=null;
		
		if(RestaurantType.VEG.name().equals(restaurantType)) {
			type=restaurantType;
		}
		if(RestaurantType.NONVEG.name().equals(restaurantType)) {
			type=restaurantType;
		}
		
		try {
			preparedStatement=connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, type);
			preparedStatement.setInt(2, ratings);
			
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				int restaurantId = resultSet.getInt(1);
				String restaurantName = resultSet.getString(2);
				double restaurantCost = resultSet.getDouble(3);
				String restaurantCuisineType = resultSet.getString(4);
				String restaType = resultSet.getString(5);
				int restaurantRatings = resultSet.getInt(6);
				String city = resultSet.getString(7);
				
				restaurant=new Restaurant();
				restaurant.setRestaurantName(restaurantName);
				restaurant.setRestaurantId(restaurantId);
				restaurant.setCastForTwo(restaurantCost);
				restaurant.setCuisine(restaurantCuisineType);
				restaurant.setRatings(restaurantRatings);
				restaurant.setType(restaType);
				restaurant.setCity(city);
				
				listOfRestaurants.add(restaurant);
				
			}
			
		} catch (SQLException sqlException) {
		 System.out.println(sqlException.getMessage());
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				
				restaurantDAO.closeConnection();
			}catch (SQLException  sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		if(listOfRestaurants.isEmpty()) {
			throw new RestaurantNotFoundExcetion("Restaurants not available!!!.");
		}
		
		return listOfRestaurants;
	}

}
