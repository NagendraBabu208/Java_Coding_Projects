package com.jdbc.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class InsertStudentData {

	public static void main(String[] args) {

		Properties properties= new Properties();


		try {
			properties.load(new FileReader("db.properties"));
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println(fileNotFoundException.getMessage());
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
		}

		String dbUrl=properties.getProperty("url");
		String userName=properties.getProperty("userName");
		String dbPassword=properties.getProperty("userPassword");
		Connection connection=null;
		Statement statement=null;
		Scanner scanner=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection(dbUrl, userName, dbPassword);
			statement=connection.createStatement();

			System.out.println("Enter the User values ");
			scanner=new Scanner(System.in);
			for(int i=1;i<=5;i++) {
				int id=scanner.nextInt();
				String name=scanner.next();
				String address=scanner.next();

				String query="Insert into Student values("+id+",'"+name+"','"+address+"')";
				statement.execute(query);

			}
			System.out.println("Records are inserted!!!.");

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
				if(scanner!=null) {
					scanner.close();
				}
			} catch (SQLException sqlException2) {
				System.out.println(sqlException2.getMessage());

			}
		}
	}
}
