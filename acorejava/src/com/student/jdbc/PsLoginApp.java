package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import lombok.Cleanup;

public class PsLoginApp {

	private static final String SQL_QUERY = "SELECT * FROM USER_INFO WHERE USERNAME = ? AND PASSWORD = ?";

	public static void main(String[] args) throws SQLException {

		@Cleanup
		Scanner scanner = new Scanner(System.in);
		@Cleanup
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		@Cleanup
		PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

		System.out.println("Enter username : ");
		String username = scanner.nextLine();
		System.out.println("Enter password : ");
		String password = scanner.nextLine();

		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		@Cleanup
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			System.out.println("Valid Credentials.");
			System.out.printf("%s %s", new Object[] { resultSet.getString(1), resultSet.getString(2) });
		} else {
			System.out.println("Invalid credentials.");
		}
	}
}
