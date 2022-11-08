package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MultipleInsertAudience {
	/*
	 * SQL>create table audience(audience_id int primary key,name varchar2(25) not
	 * null,avg number(5,2));
	 */

	private static final String SQL = "INSERT INTO AUDIENCE(name,audience_id,avg) values (?,?,?)";

	public static void main(String[] args) {
		int insertCount = 0;
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
						"utsab");
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {
			System.out.println("Enter audience count: ");
			int count = Integer.valueOf(scanner.nextLine());
			System.out.println("Enter audience details: ");

			for (int index = 1; index <= count; index++) {
				System.out.println("Enter name: ");
				preparedStatement.setString(1, scanner.nextLine());
				System.out.println("Enter audience_id: ");
				preparedStatement.setInt(2, Integer.valueOf(scanner.nextLine()));
				System.out.println("Enter avg: ");
				preparedStatement.setFloat(3, Float.valueOf(scanner.nextLine()));
				insertCount = insertCount + preparedStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The number of record insert into Audience table : " + insertCount);
	}
}
