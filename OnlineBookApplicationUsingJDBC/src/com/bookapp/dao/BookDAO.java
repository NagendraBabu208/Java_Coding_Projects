package com.bookapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BookDAO {
	
	static Connection connection;
	
	public static Connection getConnection() {
		
		Properties properties =new Properties();
		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.getMessage());
		} catch (IOException ioException) {
			System.out.println(ioException);
			
		}
		
		String dbUrl=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String dbPassword=properties.getProperty("userPassword");
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(dbUrl, userName, dbPassword);
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
			
			}catch(SQLException sqlException) {
				System.out.println(sqlException.getMessage());
			}
		
		return connection;
	}
	
	public static void closeConnection() {
	 if(connection!=null) {
		 try {
			connection.close();
		 } catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		 }
	 }
	}

}
