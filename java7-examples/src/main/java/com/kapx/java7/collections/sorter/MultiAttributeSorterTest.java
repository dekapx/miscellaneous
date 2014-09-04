package com.kapx.java7.collections.sorter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MultiAttributeSorterTest {
	public static void main(String[] args) {
		multiColumnSort();
	}

	private static void multiColumnSort() {
		List<Student> records = getObjects();
		List<String> attributes = new LinkedList<String>();
		attributes.add("firstName");
		// attributes.add("lastName");
		// attributes.add("marks");

		// display(records);
		System.out.println("//------------------------------------------------------------//");
		long start = System.nanoTime();
		MultiAttributeSorter.sort(records, attributes, false);
		long end = System.nanoTime();
		System.out.println("elapsed (ms)=" + ((end - start) / 1000000));
		display(records);
		System.out.println("//------------------------------------------------------------//");
	}

	private static List<Student> getObjects() {
		List<Student> records = new ArrayList<Student>();

		records.add(new Student(1, "Ram", "Lal", 25, 33.5));
		records.add(new Student(2, "Ram", "Singh", 23, 43.5));
		records.add(new Student(3, "Prem", "Sharma", 22, 23.5));
		records.add(new Student(3, "Prem", "Sharma", 21, 23.5));
		records.add(new Student(4, "Ram", "Syarma", 24, 73.5));
		records.add(new Student(5, "Ram", "Pal", 27, 63.5));
		records.add(new Student(6, "Prem", "Kishore", 22, 23.5));
		records.add(new Student(7, "Ram", "Bir", 24, 72.5));
		records.add(new Student(8, "Ram", "Bir", 22, 73.5));
		records.add(new Student(9, "Prem", "Singh", 22, 23.5));

		return records;
	}

	private static void display(List<Student> records) {
		for (Student Student : records) {
			System.out.println(Student);
		}
	}
}
