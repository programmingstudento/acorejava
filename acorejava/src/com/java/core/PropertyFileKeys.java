package com.java.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PropertyFileKeys {
	public static void main(String[] args) {
		var one = new TreeSet<String>();
		one.add("banana");
		one.add("apple");
		System.out.println(one);
		String pathOne = "D:\\Prop1.properties", pathTwo = "D:\\Prop2.properties";
		var keyOne = getPropertyKey(pathOne);
		var keyTwo = getPropertyKey(pathTwo);
		System.out.println(keyMissing(keyOne, keyTwo));
	}

	// returns keys that are two in but not in one and that are in one but not in
	// two.
	public static String keyMissing(Set<String> one, Set<String> two) {
		String result = null;
		if (one != null && two != null) {
			String message1 = "Prop1", message2 = "Prop2", message3 = "missing";
			Set<String> data1 = new TreeSet<>(two), data2 = new TreeSet<>(one);
			data1.removeAll(one);
			data2.removeAll(two);

			String result1 = data1.stream().map(item -> String.format("%s: %s : %s", message1, item, message3))
					.collect(Collectors.joining(String.format("%s%n", "")));
			String result2 = data2.stream().map(item -> String.format("%s: %s : %s", message2, item, message3))
					.collect(Collectors.joining(String.format("%s%n", "")));
			result = String.format("%s%n%s", new Object[] { result1, result2 });
		}
		return result;
	}

	public static Set<String> getPropertyKey(String filePath) {
		Set<String> keys = null;
		try (FileReader fileReader = new FileReader(new File(filePath));) {
			Properties properties = new Properties();
			properties.load(fileReader);
			keys = new HashSet<>();

			Enumeration<Object> key = properties.keys();
			for (; key.hasMoreElements();) {
				keys.add(String.valueOf(key.nextElement()));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keys;
	}
}
