package com.kapx.java7.collections.pagging;

import java.util.ArrayList;
import java.util.List;

public class PageableDemo {
	public static void main(String[] args) {
		final List<Student> students = new ArrayList<Student>();
		for (int i = 1; i <= 44; i++) {
			final Student student = new Student(i, "fname" + i, "lname" + i, new Double(i * 2));
			students.add(student);
		}

		final PageBuilder<Student> pageable = new PageBuilder<Student>(students, 21);
		final int maxPages = pageable.getMaxPages();
		System.out.println("MaxPages: " + maxPages);

		for (int i = 1; i <= maxPages; i++) {
			pageable.setPage(i);

			List<Student> subList = pageable.getListForPage();
			for (Student student : subList) {
				System.out.println(student);
			}
			System.out.println("----------------------------------");
		}

	}
}
