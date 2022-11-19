package com.java.core;

import java.util.Arrays;

public class SearchString {
	public static void main(String[] args) {
		String[] names = { "Cecilio Johnes", "Cordell Acott", "Curtice Bleue", "Dalis Menary", "Emanuele Barstock",
				"Emmy Bradane", "Gian Cossington", "Jamaal Danilevich", "Kerri Wilce", "Liuika Cowern",
				"Merrel Cornuau", "Marena Appleton", "Marlee Stobo", "Rochette Brew", "Rudyard Abbate", "Sharona Climo",
				"Shirlee Titcumb", "Taite Joriot", "Taite Huntriss", "Zach Simchenko" };

		displaySearchString1(names, "c");
		System.out.println();
		displaySearchString1(names, "co");
		System.out.println();

		displaySearchString2(names, "c");
		System.out.println();
		displaySearchString2(names, "co");
	}

	public static void displaySearchString2(String[] names, String searchString) {
		Arrays.stream(names).filter(name -> isMatching2(name, searchString)).forEach(System.out::println);
	}

	public static void displaySearchString1(String[] names, String searchString) {
		for (String name : names) {
			if (isMatching1(name, searchString)) {
				System.out.println(name);
			}
		}
	}

	private static boolean isMatching2(String word, String search) {
		String regex1 = String.format("^%s[a-z]*$", search);
		return Arrays.stream(word.split("\\s{1,}")).filter(txt -> txt.toLowerCase().matches(regex1)).count() > 0L;
	}

	private static boolean isMatching1(String word, String search) {
		String[] words = word.split("\\s{1,}");
		String regex1 = String.format("^%s[a-z]*$", search);
		int count = 0;
		for (String text : words) {
			if (text.toLowerCase().matches(regex1)) {
				count += 1;
			}
		}
		return count > 0;
	}
}
