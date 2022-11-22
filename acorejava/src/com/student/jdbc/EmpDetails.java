package com.student.jdbc;

import static java.lang.System.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class EmpDetails {

	private static final String CALL_EMP_PROC = "{CALL GET_EMP_DETAILS_PRC(?,?,?,?)}";

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				CallableStatement callableStatement = connection.prepareCall(CALL_EMP_PROC);) {
			out.print("Enter empno : ");
			int empNumber = scanner.nextInt();
			callableStatement.setInt(1, empNumber);
			callableStatement.registerOutParameter(2, Types.DOUBLE);
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.registerOutParameter(4, Types.VARCHAR);

			callableStatement.execute();
			out.format("Ename : %s Salary : %.0f Job : %s%n", callableStatement.getString(4),
					callableStatement.getDouble(2), callableStatement.getString(3));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
