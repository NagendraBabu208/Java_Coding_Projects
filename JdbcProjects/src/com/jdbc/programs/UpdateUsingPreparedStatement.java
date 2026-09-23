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

public class UpdateUsingPreparedStatement {

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
		String sqlQuery="Update Book set author=? where bookId=?";
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Scanner scanner=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection(dbUrl, userName, userPassword);
			preparedStatement=connection.prepareStatement(sqlQuery);
			System.out.println("enter Book values:: ");
			scanner=new Scanner(System.in);
					String updatedAuthor=scanner.next();
			int bookId=scanner.nextInt();
			preparedStatement.setString(1, updatedAuthor);
			preparedStatement.setInt(2, bookId);

			preparedStatement.execute();

		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.getMessage();
		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
			
		}finally {
			if(scanner!=null) {
				scanner.close();
			}
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
