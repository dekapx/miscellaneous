package com.kapx.java8.collection.compare;

public class Student {
	private final Long Id;
	private final String name;
	private final Double marks;

	public Student(final Long id, final String name, final Double marks) {
		Id = id;
		this.name = name;
		this.marks = marks;
	}

	public Long getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public Double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "[ " + getId() + " " + getName() + " " + getMarks() + " ]";
	}
}
