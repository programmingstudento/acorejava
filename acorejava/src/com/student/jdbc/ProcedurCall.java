package com.student.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import static java.lang.System.out;

public class ProcedurCall {
	private static final String PROCEDURE_CALL = "{CALL POW(?,?,?)}";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				CallableStatement callableStatement = connection.prepareCall(PROCEDURE_CALL);) {
			out.print("Enter number to square and cube : ");
			int number = scanner.nextInt();
			callableStatement.setInt(1, number);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.execute();

			out.format("The square and cube of  number %d are %d and %d",
					new Object[] { number, callableStatement.getInt(2), callableStatement.getInt(3) });
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
