package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UpdateEmployeeRecord {
	
	public static void main(String[] args) {
		
		Properties properties= new Properties();
		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException);
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
			
		}
		
		String dbUrl=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String dbPassword=properties.getProperty("userPassword");
		
		String updateQuery="update Employee set empDept='NonIT' where empId=1";
		
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(dbUrl, userName, dbPassword);
			statement=connection.createStatement();
			int value= statement.executeUpdate(updateQuery);
			System.out.println("Updated The Record "+value);
			
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
		}
		catch (SQLException  sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			
			try {
				if(statement!=null) {
					statement.close();
				}
				
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
		
		
		
	}

}
