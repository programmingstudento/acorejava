package com.student.jdbc;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTestLOB {
	private static final String INSERT_EMP = "INSERT INTO EMPLOYEE_LOBS (ENAME,JOB,PHOTO,RESUME) VALUES (?,?,?,?)";

	public static void main(String[] args) {
		int count = 0;
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMP);) {

			String name = null, job = null, photoPath = null, resumePath = null;
			System.out.print("Enter employee name : ");
			name = scanner.next();
			System.out.print("Enter employee job : ");
			job = scanner.next();
			System.out.print("Enter employee photo path : ");
			photoPath = scanner.next();
			System.out.print("Enter employee resume path : ");
			resumePath = scanner.next();

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, job);
			preparedStatement.setBlob(3, new FileInputStream(photoPath));
			preparedStatement.setClob(4, new FileReader(resumePath));

			count = count + preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.println("Record not inserted");
		} else {
			System.out.println("Record inserted");
		}
	}

}
