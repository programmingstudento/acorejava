package com.java.core;

public class Chief extends Worker {

	private int bonus;

	public Chief(String name, int year, int month, int dayOfMonth, int salary, int bonus) {
		super(name, year, month, dayOfMonth, salary);
		this.bonus = bonus;
	}

	public int getSalary() {
		return super.getSalary() + bonus;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return String.format("Chief [bonus=%s, salary=%s, name=%s, dateOfBirth=%s]", bonus, getSalary(), getName(),
				getDateOfBirth());
	}

}
