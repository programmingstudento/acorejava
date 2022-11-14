package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalculatorWithoutQuery {

	private static final String SQL = "SELECT DOB FROM EMPLOYEE WHERE ID = ?";

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
					LocalDate dateOfBirth = LocalDate.ofEpochDay(resultSet.getDate(1).getTime() / 86_400_000);
					LocalDate now = LocalDate.now();
					int age = (int) ChronoUnit.YEARS.between(dateOfBirth, now);
					System.out.println("Age is : " + age);
				} else {
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
