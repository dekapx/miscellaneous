package com.kapx.java8.collection.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	private static final Comparator<Student> nameComparator = (Student student1, Student student2) -> {
		return student1.getName().compareTo(student2.getName());
	};

	public static void main(String[] args) {
		final List<Student> students = create();
		display(students);

		Collections.sort(students, nameComparator);
		System.out.println("------------ after sorting on name ------------");
		display(students);
	}

	private static List<Student> create() {
		final List<Student> students = new ArrayList<>();
		students.add(new Student(1L, "Charlie", 87.30));
		students.add(new Student(2L, "Amy", 45.50));
		students.add(new Student(3L, "Nicole", 56.00));
		students.add(new Student(4L, "Diana", 78.80));
		students.add(new Student(5L, "Megan", 25.50));
		return students;
	}

	private static void display(final List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
