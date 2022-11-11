package com.java.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PatternPrinter {
	public static void main(String[] args) {
		int number = getPositiveInteger();
		System.out.println(createPattern(createNumbers(number)));
	}

	private static int[] createNumbers(int number) {
		int[] numbers = IntStream.rangeClosed(1, number).toArray();
		return numbers;
	}

	private static String createPattern(int[] number) {
		List<String> flip = null;
		int reverse = 1;
		StringBuilder primary = new StringBuilder();
		StringBuilder secondary = new StringBuilder();

		for (int index = 0; index < number.length; index++) {
			if (index > 0 && (index + 1) % 5 == 0) {
				if (reverse == 1 || reverse % 3 == 0) {
					primary.append(String.format("%s%d%n", secondary, number[index]));
				} else {
					flip = Arrays.asList(secondary.toString().trim().split(" "));
					Collections.reverse(flip);
					primary.append(String.format("%d %s%n", number[index], String.join("\s", flip)));
				}
				secondary = new StringBuilder();
				reverse++;
			} else {
				secondary.append(String.format("%d ", number[index]));
			}
		}
		return primary.toString();
	}

	private static int getPositiveInteger() {
		boolean isNotPositive = false;
		String pattern = "^[1-9]\\d*$";
		int result = -1;
		try (Scanner scanner = new Scanner(System.in);) {
			String number = null;
			for (; !isNotPositive;) {
				System.out.println("Enter Positive Integer");
				number = scanner.nextLine().trim();
				if (number.matches(pattern)) {
					result = Integer.valueOf(number);
					isNotPositive = true;
				}
			}
		}
		return result;
	}
}
