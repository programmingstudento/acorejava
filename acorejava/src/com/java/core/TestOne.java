package com.java.core;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TestOne {
	public static void main(String[] args) {
		SecureRandom secureRandom = new SecureRandom();
		int[] marks = IntStream.range(0, 5).map(num -> secureRandom.nextInt(100, 1001)).toArray();
		var data = maxMinMark(marks);
		System.out.println("Max is " + data.getOne());
		System.out.println("Min is " + data.getTwo());

		var maxMin = ArrayAlgorithm
				.findMinMax(new String[] { "java", "c#", "haskell", "ruby", "python", "javascript" });
		System.out.println(maxMin.getOne() + " " + maxMin.getTwo());
	}

	private static Couple<Integer> maxMinMark(int[] marks) {
		if (marks == null || marks.length == 0) {
			return null;
		}
		var mark = Arrays.copyOf(marks, marks.length);
		Arrays.sort(mark);
		return new Couple<Integer>(mark[marks.length - 1], mark[0]);
	}
}
