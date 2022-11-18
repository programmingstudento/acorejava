package com.java.core;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Reverse {

	public static void main(String[] args) {
		char[] one = { 'a', 'b', 'c', 'd', 'e' }, two = { 'a', 'b', 'c', 'd', 'e' }, three = { 'a', 'b', 'c', 'd' },
				four = { 'a', 'b', 'c', 'd', 'e' };
		System.out.println(Arrays.toString(one));
		System.out.println(System.identityHashCode(one));

		reverseArray(one);
		System.out.println(Arrays.toString(one));
		System.out.println(System.identityHashCode(one));

		System.out.println();

		System.out.println(Arrays.toString(two));
		System.out.println(System.identityHashCode(two));

		reverse(two);
		System.out.println(Arrays.toString(two));
		System.out.println(System.identityHashCode(two));

		System.out.println();

		System.out.println(Arrays.toString(three));
		System.out.println(System.identityHashCode(three));
		reverser(three);
		System.out.println(Arrays.toString(three));
		System.out.println(System.identityHashCode(three));

		System.out.println();

		System.out.println(Arrays.toString(four));
		System.out.println(System.identityHashCode(four));
		reverser(four);
		System.out.println(Arrays.toString(four));
		System.out.println(System.identityHashCode(four));
	}

	private static void reverser(char[] first) {
		int size = first.length;
		char store = '\u0000'; // null character
		for (int index = 0; index < first.length / 2; index++) { // int division 3 /2 --> 1, 4 / 4 --> 1, 0 / 1 --> 0
			store = first[index];
			first[index] = first[size - index - 1];
			first[size - index - 1] = store;
			System.out.println(Arrays.toString(first));
		}
	}
	// Imperative
	private static void reverseArray(char[] first) {
		char[] firstCopy = Arrays.copyOf(first, first.length);
		int size = firstCopy.length;
		for (int index = 0; index < size; index++) {
			first[size - index - 1] = firstCopy[index];
		}
	}

	// Declarative
	private static void reverse(char[] first) {
		int size = first.length;
		char[] firstCopy = new char[size];
		System.arraycopy(first, 0, firstCopy, 0, size);
		IntStream.range(0, size).forEach(index -> {
			first[size - index - 1] = firstCopy[index];
			return;
		});
	}

}
