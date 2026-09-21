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

public class ScrollableResultSetExample {

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
		String dbPassword=properties.getProperty("userPassword");

		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection=DriverManager.getConnection(dbUrl, userName, dbPassword);

			statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet=statement.executeQuery("Select * from Employee");
			resultSet.afterLast();

			while(resultSet.previous()) {
				int empId=resultSet.getInt(1);
				String empName=resultSet.getString(2);
				String empDept=resultSet.getString(3);
				double empSalary=resultSet.getDouble(4);
				Date empHireDate=resultSet.getDate(5);
				System.out.println("=====================================================================");
				System.out.println("EmpId::- "+empId+" empName::- "+empName+" empDept::- "+empDept+" empSalary::- "+empSalary+" empHireDate::- "+empHireDate);
			}
			System.out.println("");
			resultSet.absolute(5);
			System.out.println("EmpId::- "+resultSet.getInt(1)+" empName::- "+resultSet.getString(2)+" empDept::- "+resultSet.getString(3)+" empSalary::- "+resultSet.getDouble(4)+" empHireDate::- "+resultSet.getDate(5));
			System.out.println(" ");
			resultSet.first();
			System.out.println("EmpId::- "+resultSet.getInt(1)+" empName::- "+resultSet.getString(2)+" empDept::- "+resultSet.getString(3)+" empSalary::- "+resultSet.getDouble(4)+" empHireDate::- "+resultSet.getDate(5));
			System.out.println(" ");
		} catch (ClassNotFoundException classNotFoundException) {
			System.out.println(classNotFoundException.getMessage());

		}catch (SQLException sqlException) {
			System.out.println(sqlException.getMessage());
		}finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}


				if(statement!=null) {
					statement.close();
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
