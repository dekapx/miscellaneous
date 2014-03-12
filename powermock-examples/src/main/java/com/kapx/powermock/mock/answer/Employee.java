package com.kapx.powermock.mock.answer;

public class Employee {
	private Long id;
	private String name;

	public Employee(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
