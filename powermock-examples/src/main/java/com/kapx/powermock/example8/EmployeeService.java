package com.kapx.powermock.example8;

public class EmployeeService {

	public int getEmployeeCount() {
		return Employee.count();
	}

	public boolean giveIncrementToAllEmployeesOf(int percentage) {
		try {
			Employee.giveIncrementOf(percentage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void saveEmployee(Employee employee) {
		if (employee.isNew()) {
			employee.setEmployeeId(EmployeeIdGenerator.getNextId());
			employee.create();
			WelcomeEmail emailSender = new WelcomeEmail(employee, "Welcome to Mocking with PowerMock How-to!");
			emailSender.send();
			return;
		}
		employee.update();
	}

	public Employee findEmployeeByEmail(String email) {
		throw new UnsupportedOperationException();
	}

	public boolean employeeExists(Employee employee) {
		throw new UnsupportedOperationException();
	}
}
