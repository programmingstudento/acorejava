package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SurrogateKeyInsert {
	private static final String INSERT_SQL = "INSERT INTO PERSON(NAME,AGE) VALUES(?,?)";

	public static void main(String[] args) {
		int count = 0;
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);) {
			System.out.print("Enter person name: ");
			String name = scanner.next();
			System.out.print("Enter person age: ");
			int age = scanner.nextInt();

			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			count += preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.println("Record Not Inserted");
		} else {
			System.out.println("Record inserted");
		}
	}
}
