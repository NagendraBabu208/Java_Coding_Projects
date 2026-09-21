package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBaseTable {
	
	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost:3306/nagedra";
		String userName="root";
		String password="root";
		String createTableSqlQuery =
			    "CREATE TABLE Employee (" +
			    "empId INT AUTO_INCREMENT PRIMARY KEY, " +
			    "empName VARCHAR(100) NOT NULL, " +
			    "empDept VARCHAR(50), " +
			    "empSalary DECIMAL(10,2), " +
			    "hireDate DATE" +
			    ")";
		Connection connection=null;
		Statement statement=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url, userName, password);
			
			statement=connection.createStatement();
			boolean value=statement.execute(createTableSqlQuery);
			
			System.out.println("Table is created:: "+value);
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
				} catch (SQLException sqlException) {
					System.out.println(sqlException.getMessage());
				}
			
		
		}
		
	}

}
