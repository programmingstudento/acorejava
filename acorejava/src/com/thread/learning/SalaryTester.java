package com.thread.learning;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SalaryTester {

	private static final List<Employee> employees;

	static {
		employees = List.of(new Employee(1, "Java", 10_000, 30), new Employee(2, "Javascript", 5_000, 25),
				new Employee(3, "SQL", 8_000, 26), new Employee(4, "Typescript", 6_000, 20),
				new Employee(5, "Scala", 4_000, 24), new Employee(6, "Ruby", 3_000, 30),
				new Employee(7, "Haskell", 6_000, 25));
	}

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		employees.stream().forEach(System.out::println);
		System.out.println();
		employees.stream().forEach(employee -> executors.submit(new SalaryCalculation(employee)));
		executors.shutdown();
		employees.stream().forEach(System.out::println);
	}
}
