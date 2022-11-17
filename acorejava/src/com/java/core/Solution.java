package com.java.core;

import static java.lang.Math.pow;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static String pattern(int n) {

		return IntStream.range(1, n + 1).mapToObj(number -> String.valueOf(number).repeat(number))
				.collect(Collectors.joining("\n"));
	}

	public static boolean hasUniqueChars(String str) {
		return (int) Arrays.stream(str.split("")).map(ch -> ch.codePointAt(0)).distinct().count() == str.length();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().spoonerize("nit picking"));
		System.out.println("Pineapple pizza is delicious".replaceAll(".?[iI].?", ""));
		System.out.println(pattern(-10));
	}

	public static String shortcut(String input) {
		final String AVOID = "aeiou";
		return Arrays.stream(input.split("")).filter(txt -> AVOID.indexOf(txt) != -1).collect(Collectors.joining(""));
	}

	public static String getDay(int n) {
		class WeekDay {
			private String day(int number) {
				Map<Integer, String> days = Map.of(1, "Sunday", 2, "Monday", 3, "Tuesday", 4, "Wednesday", 5,
						"Thursday", 6, "Friday", 7, "Saturday");
				return days.getOrDefault(number, "Wrong, please enter a number between 1 and 7");
			}
		}
		return new WeekDay().day(n);
	}

	public static int square(int n) {
		IntSupplier square = () -> (int) pow(n, 2);
		return square.getAsInt();
	}

	public String spoonerize(String words) {
		String[] text = words.split(" ");
		return String.format("%c%s %c%s", text[1].charAt(0), text[0].substring(1), text[0].charAt(0),
				text[1].substring(1));

	}

	public static BigInteger pell(int n) {
		if (n <= 2) {
			return BigInteger.valueOf(n);
		}
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.TWO;
		BigInteger three = BigInteger.ZERO;

		for (int i = 3; i <= n; i++) {
			three = two.multiply(BigInteger.TWO).add(one);
			one = two;
			two = three;
		}

		return two;
	}

	public static long fibonacci(long max) {

		var fib = new ArrayList<Long>();
		fib.add(0L);
		fib.add(1L);
		for (int i = 1; fib.get(i - 1) + fib.get(i) < max; i++) {
			fib.add(fib.get(i - 1) + fib.get(i));
		}

		return fib.stream().mapToLong(n -> n).reduce(0, (accum, number) -> {
			if (number % 2 == 0) {
				return accum + number;
			}
			return accum;
		});
	}
	/*
	 * let arr = [1,1,1] for (let i=2;i<n;i++){ arr.push(arr[i-1]+arr[i-2]) } return
	 * arr[n]
	 */

	public static long padovan(int n) {
		var numbers = new ArrayList<Integer>();
		numbers.addAll(List.of(1, 1, 1));
		IntStream.range(2, n).forEach(num -> numbers.add(numbers.get(num - 1) + numbers.get(num - 2)));
		return numbers.get(n);
	}
}
