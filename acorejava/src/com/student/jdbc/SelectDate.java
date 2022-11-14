package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class SelectDate {

	private static final String SQL = "SELECT * FROM EMPLOYEE";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
				"utsab");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SQL);) {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
			SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S", Locale.FRANCE);

			while (resultSet.next()) {
				System.out.format("Id: %d Ename : %s DOB : %s TOB : %s DOJ : %s%n",
						new Object[] { resultSet.getInt(1), resultSet.getString(2),
								dateFormat.format(resultSet.getDate(3)), resultSet.getString(4),
								timestampFormat.format(resultSet.getTimestamp(5)) });
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
