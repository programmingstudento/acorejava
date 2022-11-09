package com.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CharacterCount {

	private Path path;
	private char character;

	public CharacterCount(String path, char character) {
		this.path = Path.of(path);
		this.character = character;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);) {
			System.out.print("Enter URI Path : ");
			String path = scanner.next();
			System.out.print("Enter character to count : ");
			char character = scanner.next().charAt(0);
			int count = new CharacterCount(path, character).countCharacter();
			System.out.format("The count of o is %x", count);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public int countCharacter() throws IOException {
		BufferedReader bufferedReader = Files.newBufferedReader(path);
		return bufferedReader.lines().mapToInt(text -> text.trim().replaceAll("[^" + character + "]", "").length())
				.sum();
	}

}
