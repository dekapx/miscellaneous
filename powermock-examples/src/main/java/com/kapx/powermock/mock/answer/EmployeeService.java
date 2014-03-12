package com.kapx.powermock.mock.answer;

public class EmployeeService {
	private EmployeeDAO employeeDAO;

	public Employee save(Employee entity) {
		return employeeDAO.save(entity);
	}
}
