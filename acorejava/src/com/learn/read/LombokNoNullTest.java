package com.learn.read;

public class LombokNoNullTest {

	public static void main(String[] args) {
		LombokNoNullOnField field = new LombokNoNullOnField();
		field.setId(1);
		field.setSalary(1000);
		field.setName(null);
		System.out.println(field);

	}
}
