package com.kapx.java7.collections.pagging;

public class Student {
	private long id;
	private String firstName;
	private String lastName;
	private double marks;

	public Student(long id, String firstName, String lastName, double marks) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.marks = marks;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "[ " + id + " " + firstName + " " + lastName + " " + marks + " ]";
	}
}
