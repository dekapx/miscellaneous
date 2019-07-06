package com.kapx.java.collection;

public class Person {
	private final String name;
	private final int age;

	Person(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.age;
	}
}
