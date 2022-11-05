package com.java.core;

public class Tester {

	public static void main(String[] args) {
		Worker[] workers = { new Worker("Tea", 1990, 10, 10, 10_0000), new Worker("Biscuit", 1994, 5, 17, 20_0000),
				new Chief("Thread", 1997, 3, 20, 50_000, 10000) };
		for (Worker worker : workers) {
			System.out.println(worker);
		}
	}

}
