package com.kapx.java.collection;

import java.util.Arrays;
import java.util.List;

public class IterationList {
	public static void main(String[] args) {
		final List<String> names = Arrays.asList("Steve", "Bryan", "Anna", "Maria", "Victoria");

		// different ways of iterating on collection
//		for (String name : names) {
//			System.out.println(name);
//		}

//		names.forEach((final String name) -> System.out.println(name));

//		names.forEach((name) -> System.out.println(name));

//		names.forEach(name  -> System.out.println(name));

		names.forEach(System.out::println);
	}
}
