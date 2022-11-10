package com.collection.learning;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Student implements Comparable<Student> {
	private int age;
	private String name;

	@Override
	public int compareTo(Student o) {
		int result = age - o.age;
		return result == 0 ? result : name.compareTo(o.getName());
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(age,name);
	}
}
