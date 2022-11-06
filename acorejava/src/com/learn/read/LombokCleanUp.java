package com.learn.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Cleanup;

public class LombokCleanUp {
	public static void main(String[] args) throws SQLException {
		@Cleanup
		Connection connection = DriverManager.getConnection("jdbc:thin:oracle:@localhost:1521:orcl", "scott", "tiger");

		@Cleanup
		Statement statement = connection.createStatement();

		@Cleanup
		ResultSet resultSet = statement.executeQuery("SELECT * FROM EMP");

		while (resultSet.next()) {
			System.out.printf("%d %s %s %.0f%n", new Object[] { resultSet.getInt("EMPNO"), resultSet.getString("ENAME"),
					resultSet.getString("JOB"), resultSet.getFloat("SAL") });
		}
	}
}
