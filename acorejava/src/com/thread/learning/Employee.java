package com.thread.learning;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Employee {
	@Getter
	private int id;
	@Getter
	private String name;
	@Getter
	private double baseSalary;
	@Getter
	private int workingDays;
	@Setter
	@Getter
	private double totalSalary;

	public Employee(int id, String name, double baseSalary, int workingDays) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
		this.workingDays = workingDays;
	}

}
