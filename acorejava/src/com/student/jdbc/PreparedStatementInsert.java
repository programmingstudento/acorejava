package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {

	private static final String SQL_QUERY = "INSERT INTO STUDENT VALUES (?,?,?,?)";

	public static void main(String[] args) {
		int count = 0;

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);) {
			System.out.println("Enter the number of records to insert ");
			int recordNumber = Integer.valueOf(scanner.nextLine());
			int sno = -1;
			String sname = null, sadd = null;
			float avg = -1;

			while (recordNumber > 0) {
				System.out.println("Enter the student no");
				sno = Integer.valueOf(scanner.nextLine());
				System.out.println("Enter the student name");
				sname = scanner.nextLine();
				System.out.println("Enter the student address");
				sadd = scanner.nextLine();
				System.out.println("Enter the student avg");
				avg = Float.valueOf(scanner.nextLine());
				preparedStatement.setInt(1, sno);
				preparedStatement.setString(2, sname);
				preparedStatement.setString(3, sadd);
				preparedStatement.setFloat(4, avg);
				preparedStatement.executeUpdate();
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.printf("%d Records Inserted.%n", new Object[] { count });
		} else {
			System.out.printf("%d Records Inserted.%n", new Object[] { count });
		}
	}
}
