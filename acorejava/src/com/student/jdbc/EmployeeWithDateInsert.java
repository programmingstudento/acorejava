package com.student.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class EmployeeWithDateInsert {
	private static final String SQL = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?)";

	public static void main(String[] args) {
		int count = 0;
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
						"utsab");
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);) {

			int id = -1;
			String ename = null, dob = null, tob = null, doj = null;
			System.out.println("Enter Employee Id");
			id = Integer.valueOf(scanner.nextLine());
			System.out.println("Enter Employee Name");
			ename = scanner.nextLine();
			System.out.println("Enter Employee DOB in yyyy-MM-dd format");
			dob = scanner.nextLine();
			System.out.println("Enter Employee TOB in hh:mm:ss format");
			tob = scanner.nextLine();
			System.out.println("Enter Employee DOJ in  yyyy-MM-dd hh:mm:ss.f format");
			doj = scanner.nextLine();

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, ename);
			preparedStatement.setDate(3, Date.valueOf(dob));
			preparedStatement.setString(4, tob);
			preparedStatement.setTimestamp(5, Timestamp.valueOf(doj));

			count = count + preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
		}

		if (count == 0) {
			System.out.println("No records inserted.");
		} else {
			System.out.println("Records inserted.");
		}
	}
}
