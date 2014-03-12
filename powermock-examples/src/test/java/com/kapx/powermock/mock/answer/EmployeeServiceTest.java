package com.kapx.powermock.mock.answer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.reflect.Whitebox;

public class EmployeeServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSave() {
		EmployeeDAO employeeDAO = mock(EmployeeDAO.class);
		when(employeeDAO.save(any(Employee.class))).thenAnswer(new Answer<Employee>() {

			@Override
			public Employee answer(InvocationOnMock invocation) throws Throwable {
				return new Employee(1L, "Dummy Employee");
			}
		});

		EmployeeService service = new EmployeeService();
		Whitebox.setInternalState(service, "employeeDAO", employeeDAO);

		Employee employee = service.save(new Employee(null, "test"));
		assertNotNull(employee);
		assertTrue(1L == employee.getId());
	}

}
