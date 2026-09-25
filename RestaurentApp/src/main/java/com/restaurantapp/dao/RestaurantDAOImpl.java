package com.restaurantapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class RestaurantDAOImpl implements IRestaurantDAO {
	private static Connection connection;

	@Override
	public  Connection getConnection() {
		
		Properties properties=new Properties();
		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.getMessage());
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
			}
		
		String dbUrl=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String userPassword=properties.getProperty("userPassword");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
			
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}
		
		return connection;
		
	}

	@Override
	public void closeConnection() {
		
		try {
			if(connection!=null) {
				connection.close();
			}
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		
	}



}
