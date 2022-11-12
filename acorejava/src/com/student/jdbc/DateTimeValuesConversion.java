package com.student.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeValuesConversion {

	public static void main(String[] args) {
		String one = "20-10-1990 2:10:30"; // dd-MM-yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(one);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);

		// converting java.util.Date class object to java.sql.Date class object
		long milliseconds = date.getTime();
		java.sql.Date two = new java.sql.Date(milliseconds);
		System.out.println(two);
		java.sql.Time time = new java.sql.Time(milliseconds);
		System.out.println(time);
		java.sql.Date three = java.sql.Date.valueOf("1896-08-12");
		System.out.println(three);
		

	}
}
