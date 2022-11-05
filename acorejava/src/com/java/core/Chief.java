package com.java.core;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(super.hashCode(), Double.valueOf(bonus).hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chief other = (Chief) obj;
		return bonus == other.bonus;
	}

	@Override
	public String toString() {
		return String.format("[bonus=%s, toString()=%s]", bonus, super.toString());
	}

}
