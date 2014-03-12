package com.kapx.powermock.example7;

public class Employee {

	private int employeeId;

	private String email;

	public Employee() {
	}

	public Employee(String email) {
		this.email = email;
	}

	public static int count() {
		throw new UnsupportedOperationException();
	}

	public static void giveIncrementOf(int percentage) {
		throw new UnsupportedOperationException();
	}

	public void save() {
		throw new UnsupportedOperationException();
	}

	public boolean isNew() {
		throw new UnsupportedOperationException();
	}

	public void update() {
		throw new UnsupportedOperationException();
	}

	public void create() {
		throw new UnsupportedOperationException();
	}

	public void setEmployeeId(final int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}
}
