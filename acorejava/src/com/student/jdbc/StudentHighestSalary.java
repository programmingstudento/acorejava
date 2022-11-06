package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Finds and Displays the highest salary student details of student table.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 *
 */
public class StudentHighestSalary {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("user", "scott");
		properties.setProperty("password", "tiger");
		// May return 0 ---> if no record, return 1 or n(number) ----> depending on the
		// records.
		String sqlQuery = "SELECT * FROM STUDENT WHERE AVG = (SELECT MAX(AVG) FROM STUDENT)";

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", properties);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);) {
			System.out.println(sqlQuery);
			System.out.println("---------------------------------------------------------------------");

			if (resultSet.next()) {
				// Get first record.
				System.out.printf("%d %s %s %.0f%n", resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getFloat(4));
				// Get if there are more than one record having highest average in student
				// table.
				while (resultSet.next()) {
					System.out.printf("%d %s %s %.0f%n", resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getFloat(4));
				}
			} else {
				System.out.println("Student table does not have record.It is empty.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
