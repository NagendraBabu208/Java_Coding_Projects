package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TableCreatByPrepareStatement {
	
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
		 String createTableSqlQuery =
		            "CREATE TABLE Book (" +
		            "bookId INT AUTO_INCREMENT PRIMARY KEY, " +
		            "title VARCHAR(200) NOT NULL, " +
		            "author VARCHAR(100) NOT NULL, " +
		            "publisher VARCHAR(100), " +
		            "price DECIMAL(10,2), " +
		            "publishedDate DATE" +
		            ")";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			
		preparedStatement =connection.prepareStatement(createTableSqlQuery);
		boolean value=preparedStatement.execute();
		System.out.println("Table is created!!!. "+value);
			
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
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
				System.out.println(sqlException2);
			}
		}
	}
	
	

}
