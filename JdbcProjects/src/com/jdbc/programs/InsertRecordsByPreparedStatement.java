package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.util.Properties;
import java.util.Scanner;

public class InsertRecordsByPreparedStatement {
	
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
		String sqlQuery="Insert into book values(?,?,?,?,?)";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Scanner scanner=null;
	
		
	    try  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			preparedStatement=connection.prepareStatement(sqlQuery);
			System.out.println("Enter the values:: ");
			scanner=new Scanner(System.in);
			for(int i=1;i<=6;i++) {
				
				int bookId=scanner.nextInt();
				String bookTitle=scanner.next();
				String author=scanner.next();
				String publisher=scanner.next();
				double bookPrice=scanner.nextDouble();
				
				
				preparedStatement.setInt(1, bookId);
				preparedStatement.setString(2, bookTitle);
				preparedStatement.setString(3,author);
				preparedStatement.setString(4, publisher);
				preparedStatement.setDouble(5, bookPrice);
				preparedStatement.execute();
				
				
				System.out.println("Book Record is inserted:: ");
			}
			
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
			}catch (SQLException sqlException) {
				System.out.println(sqlException.getMessage());
			}finally {
				try {
				if(scanner!=null) {
					scanner.close();
				}
				
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				if(connection!=null) {
					connection.close();
				}
			    }
				catch (SQLException  sqlException2) {
					System.out.println(sqlException2.getMessage());
					// TODO: handle exception
				}
	}

}}
