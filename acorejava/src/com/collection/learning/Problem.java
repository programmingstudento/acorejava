package com.collection.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Problem {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Guauva", "Peach", "Orange");
		Collections.shuffle(fruits);

		// Through for each
		for (var fruit : fruits) {
			System.out.println(fruit);
		}
		System.out.println();
		// Iterator
		for (ListIterator<String> one = fruits.listIterator(); one.hasNext();) {
			System.out.println(one.next());
		}

		System.out.println();
		// stream
		fruits.stream().forEach(System.out::println);
	}
}
