package com.java.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProblemOne {

	public static void main(String[] args) {

		int evenTotal = Integer.MIN_VALUE;

		try (FileReader fileReader = new FileReader("D:\\numbers.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			evenTotal = evenSum(bufferedReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (evenTotal != Integer.MIN_VALUE) {
			System.out.println("The sum of even numbers : " + evenTotal);
		}
	}

	private static int evenSum(BufferedReader bufferedReader) throws IOException {
		int total = 0, index = 0, size = Integer.valueOf(bufferedReader.readLine());
		int[] numbers = new int[size];
		String data = null;

		while ((data = bufferedReader.readLine()) != null) {
			numbers[index++] = Integer.valueOf(data);
		}
		for (int number : numbers) {
			if (number % 2 == 0) {
				total += number;
			}
		}
		return total;
	}

}
