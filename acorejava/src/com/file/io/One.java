package com.file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class One {
	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		FileOutputStream outputStream = null;
		try {
			fileInputStream = new FileInputStream(new File("D:\\numbers.txt"));
			outputStream = new FileOutputStream(new File("D:\\output.txt"));
			int number;

			while ((number = fileInputStream.read()) != -1) {
				outputStream.write(number);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
