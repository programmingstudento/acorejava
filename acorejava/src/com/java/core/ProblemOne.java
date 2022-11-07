package com.java.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.IntStream;

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

	private static int evenSum(BufferedReader bufferedReader) {
		IntStream numbers = bufferedReader.lines().skip(1).mapToInt(Integer::valueOf);
		return numbers.filter(num -> num % 2 == 0).sum();
	}

}
