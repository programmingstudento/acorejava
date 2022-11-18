package com.student.jdbc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class RetrieveLob {

	private static final String GET_SQL = "SELECT * FROM EMPLOYEE_LOBS WHERE ENO = ?";

	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
						"tiger");
				PreparedStatement preparedStatement = connection.prepareStatement(GET_SQL);) {
			System.out.print("Enter employee id : ");
			preparedStatement.setInt(1, scanner.nextInt());
			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.next()) {
					InputStream inputStream = resultSet.getBinaryStream(4);
					Reader reader = resultSet.getCharacterStream(5);
					try (OutputStream outputStream = new FileOutputStream(new File("D:\\first.png"));
							Writer writer = new FileWriter(new File("D:\\hello.txt"));) {
						IOUtils.copy(inputStream, outputStream);
						IOUtils.copy(reader, writer);

						System.out.println("Success");
						System.out.format("%d %s %s%n",
								new Object[] { resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3) });
					}
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
