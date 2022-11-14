package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AgeCalculatorWithQuery {
	private static final String SQL = "SELECT ROUND(MONTHS_BETWEEN(SYSDATE,DOB)/12) AS AGE FROM EMPLOYEE WHERE ID = ?";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
						"utsab");
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
			System.out.println("Enter employee id : ");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					System.out.format("Age in %d years", resultSet.getInt("AGE"));
				}
				else {
					System.out.println("Record not found.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
