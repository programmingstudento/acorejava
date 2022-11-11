package com.collection.learning;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple", "Banana", "Guauva", "Peach", "Orange", "apple", "banana");
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

		Comparator<String> one = (String first, String second) -> first.compareToIgnoreCase(second);
		SortedSet<String> foods = new TreeSet<>(one);
		foods.addAll(fruits);
		System.out.println(foods);

		var items = Arrays.asList("read ", " run ", " dance", " eat ", " swim");
		
		for (var item : items) {
			System.out.println(item + " " + item.length());
		}

		removeSpace(items);
		items.forEach(item -> System.out.println(item + " " + item.length()));
	}

	public static void removeSpace(List<String> words) {
		for (ListIterator<String> word = words.listIterator(); word.hasNext();) {
			word.set(word.next().trim());
		}
	}
}
