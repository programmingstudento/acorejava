package com.student.jdbc;

import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * This class displays department record based on deptno.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 *
 */
public class DepartmentDetail {
	public static void main(String[] args) {
		Scanner scanner = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			scanner = new Scanner(System.in);
			out.print("Enter Department Number : ");
			int departmentNumber = scanner.nextInt();
			String sqlQuery = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", departmentNumber);

			connection = getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);

			out.println(sqlQuery);
			if (resultSet.next()) {
				out.println("Record found.");
				out.println("DEPTNO   DNAME          LOC\n-----------------------------------");
				out.printf("%d       %s     %s%n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));

			} else {
				out.println("Record not found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (scanner != null) {
				try {
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
