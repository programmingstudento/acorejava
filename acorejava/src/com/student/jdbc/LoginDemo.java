package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * LoginDemo to learn about authentication and sql injection.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 *
 */
public class LoginDemo {
	/*
	 * user_info table with records username password java java and ORACLE ORACLE
	 */
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("user", "scott");
		properties.setProperty("password", "tiger");

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						properties);
				Statement statement = connection.createStatement();) {

			out.println("Enter username : ");
			String username = scanner.nextLine();

			out.println("Enter password : ");
			String password = scanner.nextLine();

			/*
			 * sql injection if user enters username as: java' -- or user enters username
			 * as: java8' or 1=1 --
			 */
			String query = String.format("SELECT COUNT(*) FROM USER_INFO WHERE USERNAME = '%s' AND PASSWORD = '%s'",
					new Object[] { username, password });
			out.println(query);
			try (ResultSet resultSet = statement.executeQuery(query)) {
				resultSet.next();
				out.printf("%s%n",
						new Object[] { resultSet.getInt(1) == 0 ? "Invalid Credentials." : "Valid Credentials." });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
