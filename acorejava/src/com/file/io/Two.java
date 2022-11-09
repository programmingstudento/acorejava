package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Two {
	public static void main(String[] args) {
		try (FileReader fileReader = new FileReader(new File("D:\\numbers.txt"));
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				PrintWriter printWriter = new PrintWriter(new File("D:\\output.txt"));) {

			String data = null;
			while ((data = bufferedReader.readLine()) != null) {
				printWriter.println(data);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
