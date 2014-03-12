package com.kapx.powermock.example2;

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int getEmployeeCount() {
		return employeeService.getEmployeeCount();
	}
}
