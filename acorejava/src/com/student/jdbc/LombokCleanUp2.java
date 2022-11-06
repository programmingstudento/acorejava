package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import lombok.Cleanup;

public class LombokCleanUp2 {
	public static void main(String[] args) throws SQLException {
		@Cleanup
		Scanner scanner = new Scanner(System.in);

		@Cleanup
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

		@Cleanup
		Statement statement = connection.createStatement();

		System.out.println("Enter emp name : ");

		@Cleanup
		ResultSet resultSet = statement.executeQuery("SELECT * FROM EMP WHERE ename = '" + scanner.nextLine() + "'");

		if (resultSet.next()) {
			System.out.println("The records are : ");
			System.out.println("---------------------------------------------------------------");
			System.out.printf("%d %s %s %.0f%n", new Object[] { resultSet.getInt("EMPNO"), resultSet.getString("ENAME"),
					resultSet.getString("JOB"), resultSet.getFloat("SAL") });
			while (resultSet.next()) {
				System.out.printf("%d %s %s %.0f%n", new Object[] { resultSet.getInt("EMPNO"),
						resultSet.getString("ENAME"), resultSet.getString("JOB"), resultSet.getFloat("SAL") });
			}
		}

		else {
			System.out.println("No Records available");
		}
	}
}
