package com.kapx.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCollection {
	public static void main(String[] args) {
		sort();
		sortWithLambda1();
		sortWithLambda2();
		sortWithLambda3();
	}

	private static void sort() {
		final List<Person> persons = getPersons();
		Collections.sort(persons, new NameComparator());
		System.out.println(persons);
	}

	private static void sortWithLambda1() {
		final List<Person> persons = getPersons();
		Collections.sort(persons, (final Person p1, final Person p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println(persons);
	}

	private static void sortWithLambda2() {
		final List<Person> persons = getPersons();
		Collections.sort(persons, (Person p1, Person p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println(persons);
	}

	private static void sortWithLambda3() {
		final List<Person> persons = getPersons();
		Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println(persons);
	}

	private static List<Person> getPersons() {
		final List<Person> persons = new ArrayList<>();
		persons.add(new Person("James", 21));
		persons.add(new Person("Bryan", 35));
		persons.add(new Person("Steve", 31));
		persons.add(new Person("Anya", 18));
		persons.add(new Person("Christy", 25));
		return persons;
	}
}
