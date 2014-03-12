package com.kapx.powermock.example1;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;

import com.kapx.powermock.example1.Employee;
import com.kapx.powermock.example1.EmployeeController;
import com.kapx.powermock.example1.EmployeeService;

public class EmployeeControllerTest {

	@Test
	public void shouldReturnProjectedCountOfEmployeesFromTheService() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		when(mock.getEmployeeCount()).thenReturn(8);

		EmployeeController employeeController = new EmployeeController(mock);
		assertEquals(10, employeeController.getProjectedEmployeeCount());
	}

	@Test
	public void shouldReturnProjectedCountOfEmployeesFromTheServiceRoundedToTheCeiling() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		when(mock.getEmployeeCount()).thenReturn(6);

		EmployeeController employeeController = new EmployeeController(mock);
		assertEquals(8, employeeController.getProjectedEmployeeCount());
	}

	@Test
	public void shouldReturnCountOfEmployeesFromTheServiceWithDefaultAnswer() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class, new Answer<Integer>() {
			@Override
			public Integer answer(InvocationOnMock invocation) {
				return 10;
			}
		});

		EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertEquals(12, employeeController.getProjectedEmployeeCount());
	}

	@Test
	public void shouldInvokeSaveEmployeeOnTheServiceWhileSavingTheEmployee() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		EmployeeController employeeController = new EmployeeController(mock);

		Employee employee = new Employee();
		employeeController.saveEmployee(employee);

		Mockito.verify(mock).saveEmployee(employee);
	}

	@Test
	public void shouldInvokeSaveEmployeeOnTheServiceWhileSavingTheEmployeeWithMockSettings() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class, Mockito.withSettings().name("EmployeeServiceMock").verboseLogging());

		EmployeeController employeeController = new EmployeeController(mock);

		Employee employee = new Employee();
		employeeController.saveEmployee(employee);

		Mockito.verify(mock).saveEmployee(employee);
	}
}
