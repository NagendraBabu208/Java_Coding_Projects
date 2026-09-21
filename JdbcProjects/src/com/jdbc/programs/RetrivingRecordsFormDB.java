package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class RetrivingRecordsFormDB {
	
	public static void main(String[] args) {
		
		Properties properties=new Properties();
		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.getMessage());
			
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
			
		}
		
		String url=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String dbPassword=properties.getProperty("userPassword");
		
		Connection connection=null;
		Statement statement= null;
		ResultSet resultSet=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url, userName, dbPassword);
			
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from Employee");
			
			while (resultSet.next()) {
				int employeeId=resultSet.getInt(1);
				String empName=resultSet.getString(2);
				String empDept=resultSet.getString(3);
				double empSalary=resultSet.getDouble(4);
				 Date hireDate=resultSet.getDate(5);
				 
				 System.out.println("empId "+employeeId+" empName"+empName+" empDert "+empDept+" empSalary "+empSalary+" hireDate"+hireDate);
				
				
			}
			
			
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());
			
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			
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
