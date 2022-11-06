package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static java.lang.System.out;

/**
 * Deletes records from emp table based on the given salary range.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 */
public class DeleteEmp {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "utsab",
						"utsab");
				Statement statement = connection.createStatement();) {

			out.print("Enter first salary : ");
			double salary1 = scanner.nextDouble();
			out.println();
			out.print("Enter second salary : ");
			double salary2 = scanner.nextDouble();
			out.println();

			String query = String.format("DELETE FROM EMP WHERE SAL BETWEEN %.2f and %.2f", salary1, salary2);
			out.println(query);
			int count = statement.executeUpdate(query);

			if (count == 0) {
				out.println("Record not deleted.");
			} else {
				out.printf("Records deleted : %d", count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
