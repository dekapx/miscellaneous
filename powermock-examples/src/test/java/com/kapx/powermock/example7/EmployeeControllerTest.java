package com.kapx.powermock.example7;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;

public class EmployeeControllerTest {

	@Test
	public void shouldReturnCountOfEmployeesFromTheService() {

		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		PowerMockito.when(mock.getEmployeeCount()).thenReturn(10);

		EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertEquals(10, employeeController.getEmployeeCount());
	}

	@Test
	public void shouldReturnCountOfEmployeesFromTheServiceWithDefaultAnswer() {

		EmployeeService mock = PowerMockito.mock(EmployeeService.class,

		new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation) {
				return 10;
			}
		});

		EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertEquals(10, employeeController.getEmployeeCount());
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

	@Test
	public void shouldFindEmployeeByEmail() {
		final EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		final Employee employee = new Employee();

		PowerMockito.when(mock.findEmployeeByEmail(Mockito.startsWith("deep"))).thenReturn(employee);

		final EmployeeController employeeController = new EmployeeController(mock);

		Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@gitshah.com"));
		Assert.assertSame(employee, employeeController.findEmployeeByEmail("deep@packtpub.com"));

		Assert.assertNull(employeeController.findEmployeeByEmail("noreply@packtpub.com"));
	}

	@Test
	public void shouldReturnNullIfNoEmployeeFoundByEmail() {
		final EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		PowerMockito.when(mock.findEmployeeByEmail(Mockito.anyString())).thenReturn(null);

		final EmployeeController employeeController = new EmployeeController(mock);

		Assert.assertNull(employeeController.findEmployeeByEmail("xkapil@gmail.com"));
		Assert.assertNull(employeeController.findEmployeeByEmail("xkapil@gmail.com"));
		Assert.assertNull(employeeController.findEmployeeByEmail("test@test.com"));
	}

	@Test
	public void shouldReturnTrueIfEmployeeEmailIsAlreadyTaken() {
		final EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		final String employeeEmail = "xkapil@gmail.com";
		PowerMockito.when(mock.employeeExists(Mockito.argThat(new ArgumentMatcher<Employee>() {

			@Override
			public boolean matches(Object employee) {
				return ((Employee) employee).getEmail().equals(employeeEmail);
			}
		}))).thenReturn(true);

		final EmployeeController employeeController = new EmployeeController(mock);
		Assert.assertTrue(employeeController.isEmployeeEmailAlreadyTaken(employeeEmail));
	}
}
