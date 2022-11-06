package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Finds and Displays the emp with the lowest salary in emp table.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 */
public class EmpLowestSalary {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("user", "scott");
		properties.setProperty("password", "tiger");
		// May return 0 ---> if no record, return 1 or n(number) ----> depending on the
		// records.
		String sqlQuery = "SELECT * FROM EMP WHERE SAL = (SELECT MIN(SAL) FROM EMP)";

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", properties);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);) {
			System.out.println(sqlQuery);
			System.out.println("----------------------------------------------------------------");

			if (resultSet.next()) {
				// Get first record.
				System.out.printf("%d %s %s %d %td-%th-%ty %.0f %.0f %d%n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5), resultSet.getDate(5),
						resultSet.getDate(5), resultSet.getFloat(6), resultSet.getFloat(7), resultSet.getInt(8));
				// Get if there are more records having lowest salary in emp.
				while (resultSet.next()) {
					System.out.printf("%d %s %s %d %t %.0f %.0f %d%n", resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getInt(4), resultSet.getDate(5), resultSet.getFloat(6),
							resultSet.getFloat(7), resultSet.getInt(8));
				}
			} else {
				System.out.println("Emp table does not have records.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
