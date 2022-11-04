package com.java.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public record Department(int deptno, String dname, String loc) {

	public void display() {
		System.out.printf("%d %s %s%n", deptno, dname, loc);
	}

	public static void main(String[] args) {
		List<Department> departments = null;
		String sqlQuery = "SELECT * FROM DEPT";
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
				"utsab");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);) {
			departments = new ArrayList<>();
			System.out.println(sqlQuery);
			System.out.println("---------------------------------------------------------------------------------");
			while (resultSet.next()) {
				departments.add(new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
			departments.forEach(Department::display);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
