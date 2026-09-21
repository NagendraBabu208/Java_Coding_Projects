package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ResultSetMetaDataExample {
	
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
		Connection connection=null;
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("Select * from Employee");
			ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			int count=1;
			while(resultSet.next()) {
				int columnCount=resultSetMetaData.getColumnCount();
				String className=resultSetMetaData.getColumnClassName(columnCount);
				String colunmName=resultSetMetaData.getColumnName(count++);
				String tableName=resultSetMetaData.getTableName(columnCount);
				System.out.println("Colunms Count:: "+columnCount);
				System.out.println("Class Name:: "+className);
				System.out.println("ColunmName:: "+colunmName);
				System.out.println("Table Name:: "+tableName);
				System.out.println("====================================================");
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
				
			}catch (SQLException  sqlException2) {
				System.out.println(sqlException2.getMessage());
			}
		}
	}

}
