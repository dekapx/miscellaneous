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

		final PageBuilder<Student> pageBuilder = new PageBuilder<Student>(students, 10);
		final int maxPages = pageBuilder.getMaxPages();

		System.out.println("Max Pages: " + maxPages);
		System.out.println("Min Page Range: " + pageBuilder.getMinPageRange());
		System.out.println("Max Page Range: " + pageBuilder.getMaxPageRange());

		for (int i = 1; i <= maxPages; i++) {
			pageBuilder.setPage(i);

			List<Student> subList = pageBuilder.getListForPage();
			for (Student student : subList) {
				System.out.println(student);
			}
			System.out.println("----------------------------------");
		}

	}
}
