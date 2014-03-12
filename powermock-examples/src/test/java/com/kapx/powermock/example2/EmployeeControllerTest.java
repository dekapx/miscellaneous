package com.kapx.powermock.example2;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class EmployeeControllerTest {

	@Test
	public void shouldReturnCountOfEmployeesFromTheService() {
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		PowerMockito.when(mock.getEmployeeCount()).thenReturn(10);

		EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertEquals(10, employeeController.getEmployeeCount());
	}
}
