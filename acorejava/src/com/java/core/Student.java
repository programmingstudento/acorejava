package com.java.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Student {

	private String name;
	private int id;
	private LocalDate dateOfBirth;

	public Student(String name, int year, int month, int day) {
		this.name = Objects.requireNonNullElse(name, "Random");
		this.dateOfBirth = LocalDate.of(year, month, day);
		++id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, id=%s, dateOfBirth=%s]", name, id, dateOfBirth);
	}

	public static void main(String[] args) {
		List.of(new Student("Ja", 1996, 12, 12), new Student("Tik", 1995, 10, 12)).forEach(System.out::println);
	}
}
