package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AudienceMultipleInsert {
	private static final String INSERT = "INSERT INTO AUDIENCE(ANAME,AGE,GENDER,RELIGION) VALUES (?,?,?,?)";

	public static void main(String[] args) {
		int count = 0;
		int insertCount = Integer.MIN_VALUE;
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {

			displayMessage("Enter the number of records to insert into AUDIENCE table : ");
			insertCount = Integer.valueOf(scanner.nextLine());
			List<Object[]> records = collectRecord(insertCount, scanner);
			count = setValues(preparedStatement, records);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.printf("%d records inserted into AUDIENCE TABLE.", new Object[] { count });
	}

	private static int setValues(PreparedStatement preparedStatement, List<Object[]> records) throws SQLException {
		int count = 0;
		for (Object[] item : records) {
			for (int index = 0; index < item.length; index++) {
				preparedStatement.setObject(index + 1, item[index]);
			}
			count += preparedStatement.executeUpdate();
		}
		return count;
	}

	private static List<Object[]> collectRecord(int insertNumber, Scanner scanner) throws Exception {
		int number = insertNumber;
		Object[] values = null;
		List<Object[]> records = new ArrayList<>();
		while (number > 0) {
			values = new Object[4];
			displayMessage("Enter name for audience : ");
			values[0] = scanner.nextLine();
			displayMessage("Enter age for audience : ");
			values[1] = Integer.valueOf(scanner.nextLine());
			displayMessage("Enter gender for audience : ");
			values[2] = scanner.nextLine();
			displayMessage("Enter religion for audience : ");
			values[3] = scanner.nextLine();
			records.add(values);
			number--;
		}
		return records;
	}

	private static void displayMessage(String message) {
		System.out.println(message);
	}
}