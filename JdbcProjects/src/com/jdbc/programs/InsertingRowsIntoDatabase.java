package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertingRowsIntoDatabase {
	
	public static void main(String[] args) {
		
		Properties properties=new Properties();
		
		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.getMessage());
			
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
			
		}
		
		String dbURL=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String dbPassWord=properties.getProperty("userPassword");
		String insertQuery = "INSERT INTO Employee (empName, empDept, empSalary, hireDate) " +
                "VALUES ('Nagendra', 'IT', 66000.00, '2022-05-09')";
		Connection connection=null; 
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(dbURL, userName, dbPassWord);
			
			statement=connection.createStatement();
			boolean value=statement.execute(insertQuery);
			System.out.println("One row is inserted!!! "+value);
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
			
	}
		catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}
		finally {
			try {
				if(statement!=null) {
					statement.close();
				}
				if(connection!=null) {
					connection.close();
				}
				
			} catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
	}

}
