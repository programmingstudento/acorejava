package com.java.core;

import java.time.LocalDate;
import java.util.Objects;

public class Worker {
	private String name;
	private LocalDate dateOfBirth;
	private int salary;

	public Worker(String name, int year, int month, int dayOfMonth, int salary) {
		this.name = Objects.requireNonNullElse(name, "Random");
		this.dateOfBirth = LocalDate.of(year, month, dayOfMonth);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return String.format("Worker [name=%s, dateOfBirth=%s, salary=%s]", name, dateOfBirth, salary);
	}

}
