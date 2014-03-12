package com.kapx.powermock.example4;

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int getEmployeeCount() {
		return employeeService.getEmployeeCount();
	}

	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}
}
