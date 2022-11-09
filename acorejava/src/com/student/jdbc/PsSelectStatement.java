package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelectStatement {
	private final static String SQL = "SELECT empno,ename,sal,job FROM EMP WHERE SAL BETWEEN ? AND ?";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
				"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);
				Scanner scanner = new Scanner(System.in);) {

			System.out.println("Enter lower range salary : ");
			float lowRange = Float.valueOf(scanner.nextLine());
			System.out.println("Enter higher range salary: ");
			float highRange = Float.valueOf(scanner.nextLine());
			preparedStatement.setFloat(1, lowRange);
			preparedStatement.setFloat(2, highRange);

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					System.out.println();
					System.out.println("The Emp Records are : ");
					System.out.println("-------------------------------------------------------------------");
					System.out.printf("%d %s %.0f %s%n", resultSet.getInt(1), resultSet.getString(2),
							resultSet.getFloat(3), resultSet.getString(4));
					while (resultSet.next()) {
						System.out.printf("%d %s %.0f %s%n", resultSet.getInt(1), resultSet.getString(2),
								resultSet.getFloat(3), resultSet.getString(4));
					}
				} else {
					System.out.println("No Records Found");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
