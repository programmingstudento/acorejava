package com.thread.learning;

public class ProgrammingLanguage {
	public static void main(String[] args) throws InterruptedException {
		String[] languages = { "Java", "Javascript", "SQL", "C#", "Python" };
		for (var language : languages) {
			Thread.sleep(2000);
			System.out.println(language);
		}
	}
}
