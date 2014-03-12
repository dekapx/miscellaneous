package com.kapx.powermock.example8;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Employee.class, EmployeeIdGenerator.class, EmployeeService.class })
public class EmployeeServiceTest {

	@Test
	public void shouldReturnTheCountOfEmployeesUsingTheDomainClass() {
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.when(Employee.count()).thenReturn(900);

		EmployeeService employeeService = new EmployeeService();
		Assert.assertEquals(900, employeeService.getEmployeeCount());
	}

	@Test
	public void shouldReturnTrueWhenIncrementOf10PercentageIsGivenSuccessfully() {
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.doNothing().when(Employee.class);
		Employee.giveIncrementOf(10);

		EmployeeService employeeService = new EmployeeService();
		Assert.assertTrue(employeeService.giveIncrementToAllEmployeesOf(10));
	}

	@Test
	public void shouldReturnFalseWhenIncrementOf10PercentageIsNotGivenSuccessfully() {
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.doThrow(new IllegalStateException()).when(Employee.class);
		Employee.giveIncrementOf(10);

		EmployeeService employeeService = new EmployeeService();
		Assert.assertFalse(employeeService.giveIncrementToAllEmployeesOf(10));
	}

	@Test
	public void shouldInvoke_giveIncrementOfMethodOnEmployeeWhileGivingIncrement() {
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.doNothing().when(Employee.class);
		Employee.giveIncrementOf(9);

		EmployeeService employeeService = new EmployeeService();
		employeeService.giveIncrementToAllEmployeesOf(9);

		PowerMockito.verifyStatic();
		Employee.giveIncrementOf(9);
	}

	@Test
	public void shouldCreateNewEmployeeIfEmployeeIsNew() throws Exception {
		Employee employeeMock = PowerMockito.mock(Employee.class);
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);

		PowerMockito.mockStatic(EmployeeIdGenerator.class);

		WelcomeEmail welcomeEmailMock = PowerMockito.mock(WelcomeEmail.class);
		PowerMockito.whenNew(WelcomeEmail.class).withArguments(employeeMock, "Welcome to Mocking with PowerMock How-to!").thenReturn(welcomeEmailMock);

		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(employeeMock);

		Mockito.verify(employeeMock).create();

		Mockito.verify(employeeMock, Mockito.never()).update();
	}

	@Test
	public void shouldUpdateEmployeeIfEmployeeExists() {
		Employee mock = PowerMockito.mock(Employee.class);
		PowerMockito.when(mock.isNew()).thenReturn(false);

		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);

		Mockito.verify(mock).update();

		Mockito.verify(mock, Mockito.never()).create();
	}

	@Test
	public void shouldInvokeIsNewBeforeInvokingCreate() {
		Employee mock = PowerMockito.mock(Employee.class);

		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(mock);

		InOrder inOrder = Mockito.inOrder(mock);

		inOrder.verify(mock).isNew();
		inOrder.verify(mock).update();
		inOrder.verify(mock, Mockito.never()).create();
	}

	@Test
	public void shouldGenerateEmployeeIdIfEmployeeIsNew() throws Exception {
		Employee employeeMock = PowerMockito.mock(Employee.class);
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);

		PowerMockito.mockStatic(EmployeeIdGenerator.class);
		PowerMockito.when(EmployeeIdGenerator.getNextId()).thenReturn(90);

		WelcomeEmail welcomeEmailMock = PowerMockito.mock(WelcomeEmail.class);
		PowerMockito.whenNew(WelcomeEmail.class).withArguments(employeeMock, "Welcome to Mocking with PowerMock How-to!").thenReturn(welcomeEmailMock);

		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(employeeMock);

		PowerMockito.verifyStatic();
		EmployeeIdGenerator.getNextId();
		Mockito.verify(employeeMock).setEmployeeId(90);
		Mockito.verify(employeeMock).create();
	}

	@Test
	public void shouldSendWelcomeEmailToNewEmployees() throws Exception {
		Employee employeeMock = PowerMockito.mock(Employee.class);
		PowerMockito.when(employeeMock.isNew()).thenReturn(true);

		PowerMockito.mockStatic(EmployeeIdGenerator.class);
		WelcomeEmail welcomeEmailMock = PowerMockito.mock(WelcomeEmail.class);

		PowerMockito.whenNew(WelcomeEmail.class).withArguments(employeeMock, "Welcome to Mocking with PowerMock How-to!").thenReturn(welcomeEmailMock);
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(employeeMock);

		PowerMockito.verifyNew(WelcomeEmail.class).withArguments(employeeMock, "Welcome to Mocking with PowerMock How-to!");
		Mockito.verify(welcomeEmailMock).send();
	}
}
