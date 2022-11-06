package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import static java.lang.System.out;

/**
 * DepartmentCount calculates the number of records in dept table.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 */
public class DepartmentCount {

	public static void main(String[] args) {
		// username and password for scott user.
		Properties properties = new Properties();
		properties.setProperty("user", "scott");
		properties.setProperty("password", "tiger");
		String sqlQuery = "SELECT COUNT(*) COUNT_RECORD FROM DEPT";

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", properties);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery)) {

			resultSet.next();

			out.println(sqlQuery);
			out.println("--------------------------------------");
			out.printf("Count Of Dept Records : %d%n", resultSet.getInt("COUNT_RECORD"));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
