package com.jdbc.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	
	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nagedra", "root", "root");
			
			System.out.println("Connection is established "+connection);
		} catch (ClassNotFoundException classNotFoundException) {
			
		System.out.println(classNotFoundException.getMessage());
		}catch(SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException sqlException) {
				
					System.out.println(sqlException.getMessage());
				}
			}
		}
	}

}
