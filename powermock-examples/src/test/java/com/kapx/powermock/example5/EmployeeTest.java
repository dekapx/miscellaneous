package com.kapx.powermock.example5;

import org.junit.Assert;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

public class EmployeeTest {

	@Test()
	public void shouldNotDoAnythingIfEmployeeWasSaved() {
		Employee employee = PowerMockito.mock(Employee.class);
		PowerMockito.doNothing().when(employee).save();

		try {
			employee.save();
		} catch (Exception e) {
			Assert.fail("Should not have thrown an exception");
		}
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowAnExceptionIfEmployeeWasNotSaved() {
		Employee employee = PowerMockito.mock(Employee.class);
		PowerMockito.doThrow(new IllegalStateException()).when(employee).save();

		employee.save();
	}
}
