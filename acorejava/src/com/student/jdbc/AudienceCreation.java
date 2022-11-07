package com.student.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AudienceCreation {
	private static final String SEQUENCE = "CREATE SEQUENCE AUDIENCE_SEQ START WITH 1";
	private static final String CREATE_AUDIENCE = String.format(
			"CREATE TABLE AUDIENCE(AUDIENCE_ID NUMBER(2) DEFAULT AUDIENCE_SEQ.NEXTVAL PRIMARY KEY,ANAME VARCHAR2(25) %s,AGE NUMBER(3) NOT NULL CHECK(AGE > 0),"
					+ "GENDER VARCHAR2(20) NOT NULL,RELIGION VARCHAR2(20) NOT NULL)",
			"NOT NULL");

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott",
				"tiger"); Statement statement = connection.createStatement();) {

			statement.executeUpdate(SEQUENCE);
			statement.executeUpdate(CREATE_AUDIENCE);
			System.out.println("Audience Seq created.");
			System.out.println("Audience table created.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
