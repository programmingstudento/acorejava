package com.java.core;

import java.util.Iterator;
import java.util.function.Function;

public class Homework {
	private int[] numbers;

	public Homework(int size) {
		numbers = new int[size];
		for (int index = 0; index < size; index++) {
			numbers[index] = index + 1;
		}
	}

	public void displayOdd() {
		OddNumberIterator iterator = new OddNumberIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void displayOdd(Iterator<Integer> iterator) {
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void displayEven(Function<Integer, Boolean> even) {
		for (int index = 0; index < numbers.length; index++) {
			if (even.apply(numbers[index])) {
				System.out.println(numbers[index]);
			}
		}
	}

	private class OddNumberIterator implements Iterator<Integer> {
		private int index = 1;
		private int size = numbers.length;

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Integer next() {
			Integer integer = numbers[index];
			index += 2;
			return integer;
		}

	}

	public static void main(String[] args) {
		Homework homework = new Homework(20);
		homework.displayOdd();
		System.out.println("---------------------------------------------");
		homework.displayOdd(new Iterator<Integer>() {
			int index = 1;
			int[] numbers = homework.getNumbers();

			@Override
			public Integer next() {
				int number = numbers[index];
				index += 2;
				return number;
			}

			@Override
			public boolean hasNext() {
				return index < numbers.length;
			}
		});

		System.out.println("-----------------------------------------------------------");

		homework.displayEven(n -> {
			if (n % 2 == 0) {
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		});

		System.out.println("-----------------------------------------------------------");
		homework.displayEven(Homework::isEven);
	}

	public int[] getNumbers() {
		return numbers;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}

	public static boolean isOdd(int number) {
		return !isEven(number);
	}
}
