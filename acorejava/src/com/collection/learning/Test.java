package com.collection.learning;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		var students = new TreeSet<Student>();
		students.add(new Student(25, "Java"));
		students.add(new Student(27, "SQL"));
		students.add(new Student(27, "C#"));
		students.add(new Student(18, "TypeScript"));

		System.out.println(students);

		Comparator<Student> nameComparator = Comparator.comparingInt(Student::getAge).thenComparing(Student::getName);
		var student = new TreeSet<Student>(nameComparator);
		student.addAll(students);
		System.out.println(student);

		var languageStudents = new PriorityQueue<Student>();
		languageStudents.addAll(students);
		for (var item : languageStudents) {
			System.out.println(item);
		}

	}
}
