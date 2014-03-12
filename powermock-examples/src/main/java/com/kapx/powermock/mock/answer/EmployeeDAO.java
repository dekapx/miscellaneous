package com.kapx.powermock.mock.answer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private List<Employee> employee = new ArrayList<>();

	public Employee save(Employee entity) {
		employee.add(entity);
		return entity;
	}

}
