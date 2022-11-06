package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Updates emp salary by 10 % for emp in given deptno.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 */
public class UpdateEmployee {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("user", "utsab");
		properties.setProperty("password", "utsab");

		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						properties);
				Statement statement = connection.createStatement()) {
			out.println("Enter Employee Department Number : ");
			int departmentNumber = Integer.valueOf(scanner.nextLine());
			String sqlQuery = String.format("UPDATE EMP SET SAL = SAL * 1.10 WHERE DEPTNO = %d",
					new Object[] { departmentNumber });
			out.println(sqlQuery);

			int count = statement.executeUpdate(sqlQuery);
			out.printf("%d %s",
					count == 0 ? new Object[] { count, " rows updated." } : new Object[] { count, "rows updated." });

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
