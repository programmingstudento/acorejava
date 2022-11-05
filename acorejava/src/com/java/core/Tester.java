package com.java.core;

public class Tester {

	public static void main(String[] args) {
		Worker[] workers = { new Worker("Tea", 1990, 10, 10, 10_000), new Worker("Biscuit", 1994, 5, 17, 20_0000),
				new Chief("Thread", 1997, 3, 20, 50_000, 10000), new Worker("Tea", 1990, 10, 10, 10_000),
				new Chief("Thread", 1997, 3, 20, 50_000, 10000), new Worker("Biscuit", 1993, 5, 17, 20_0000) };
		for (Worker worker : workers) {
			System.out.println(worker);
		}

		var one = new Worker("Tea", 1990, 10, 10, 10_000);
		var two = new Worker("Tea", 1990, 10, 10, 10_000);
		System.out.println(one == two);
		System.out.println(one.equals(two));
		System.out.println(one.hashCode() + " " + two.hashCode());

		var three = one;
		System.out.println(one == three);
		one = new Chief("Thread", 1998, 3, 20, 50_000, 10000);
		two = new Chief("Thread", 1997, 3, 20, 50_000, 10000);
		System.out.println(one == two);
		System.out.println(one.equals(two));
		System.out.println(one.hashCode() + " " + two.hashCode());
	}
}
