package com.kapx.java7.sorter;

public class Student {
	private int studentId;
	private String firstName;
	private String lastName;
	private int age;
	private double marks;

	public Student(int studentId, String firstName, String lastName, int age, double marks) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public double getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "[ " + studentId + " " + firstName + " " + lastName + " " + age + " " + marks + " ]";
	}
}
