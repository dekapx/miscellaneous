package com.kapx.powermock.example7;

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

	public Employee findEmployeeByEmail(String email) {
		return employeeService.findEmployeeByEmail(email);
	}

	public boolean isEmployeeEmailAlreadyTaken(String email) {
		return employeeService.employeeExists(new Employee(email));
	}
}
