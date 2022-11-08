package com.java.core;

public class ArrayAlgorithm {
	public static <T extends Comparable<T>> Couple<T> findMinMax(T[] data) {
		if (data == null || data.length == 0) {
			return null;
		}
		T min = data[0], max = data[0];
		for (int index = 1; index < data.length; index++) {
			if (data[index].compareTo(min) < 0) {
				min = data[index];
			}
			if (data[index].compareTo(max) > 0) {
				max = data[index];
			}
		}
		return new Couple<>(max, min);
	}
}
