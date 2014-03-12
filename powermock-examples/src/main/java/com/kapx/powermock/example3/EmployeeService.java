package com.kapx.powermock.example3;

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
		throw new UnsupportedOperationException();
	}

}
