package com.thread.learning;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalaryCalculation extends Thread {

	private Employee employee;

	@Override
	public void run() {
		employee.setTotalSalary(employee.getBaseSalary() * employee.getWorkingDays());
	}
}
