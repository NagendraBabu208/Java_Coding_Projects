package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class RetriveRecordsByPreparedStatement {

	public static void main(String[] args) {

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
		String sqlQuery="select * from Book";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			preparedStatement=connection.prepareStatement(sqlQuery);
			
		    ResultSet resultSet=preparedStatement.executeQuery();
		    
		    while(resultSet.next()) {
		    	int bookId=resultSet.getInt(1);
		    	 String title=resultSet.getString(2);
		    	 String author=resultSet.getString(3);
		    	 String publisher=resultSet.getString(4);
		    	 Double price=resultSet.getDouble(5);
		    	 System.out.println("bookId:- "+bookId+" title:- "+title+" author:- "+author+" publisher:- "+publisher+" price:- "+price);
		    }

		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.getMessage();
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			try {

				if(preparedStatement!=null) {
					preparedStatement.close();
				}

				if(connection!=null) {
					connection.close();
				}
			}catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
	}

}
