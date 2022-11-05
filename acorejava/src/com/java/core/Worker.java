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
	public int hashCode() {
		return Objects.hash(Objects.hashCode(dateOfBirth), Objects.hashCode(name), salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(name, other.name)
				&& salary == other.salary;
	}

	@Override
	public String toString() {
		return String.format("%s [name=%s, dateOfBirth=%s, salary=%s]", getClass().getSimpleName(), name, dateOfBirth,
				salary);
	}

}
