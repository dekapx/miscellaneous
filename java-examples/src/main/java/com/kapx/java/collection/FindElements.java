package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindElements {
	public static void main(String[] args) {
		final List<String> names = Arrays.asList("Amy", "Martin", "Jeson", "Bryan", "Anna", "Maria", "Julia", "Alex", "Mary");
		System.out.println(findNamesJava7(names));

		final Predicate<String> startsWithM = getPredicate("M");
		System.out.println(findNamesJava8(names, startsWithM));

		final Predicate<String> startsWithA = getPredicate("A");
		System.out.println(findNamesJava8(names, startsWithA));
	}

	private static Predicate<String> getPredicate(final String arg) {
		return name -> name.startsWith(arg);
	}

	private static List<String> findNamesJava7(final List<String> names) {
		final List<String> namesStartsWithM = new ArrayList<>();
		for (String name : names) {
			if (name.startsWith("M")) {
				namesStartsWithM.add(name);
			}
		}
		return namesStartsWithM;
	}

	private static List<String> findNamesJava8(final List<String> names, Predicate<String> startsWithM) {
		final List<String> startsWithN = names.stream().filter(startsWithM).collect(Collectors.toList());
		return startsWithN;
	}

}
