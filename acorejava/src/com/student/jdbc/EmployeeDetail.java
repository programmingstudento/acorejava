package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.System.out;

/**
 * Employee details for those emp whose job is CLERK|SALESMAN|MANAGER.
 * 
 * @author Utsab Karkee
 * @version 18.0.0.1
 *
 */
public class EmployeeDetail {
	public static void main(String[] args) {

		String sqlQuery = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE REGEXP_INSTR(JOB,'[CMS]') = 1";
		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
				"tiger");
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery);) {

			out.println(sqlQuery);
			out.println("---------------------------------------------------------------------------------");
			while (resultSet.next()) {
				out.printf("%d   %s   %s   %.2f    %d%n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDouble(4), resultSet.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
