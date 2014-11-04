package com.kapx.jse7.concurrency.callable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TaskExecuterTest {
	private TaskExecuter taskExecuter;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		taskExecuter = new TaskExecuter();
	}

	@After
	public void tearDown() throws Exception {
		taskExecuter = null;
	}

	@Test
	public void testExecuteForException() throws Exception {
		thrown.expect(IllegalArgumentException.class);

		taskExecuter.execute(null);
	}

	@Test
	public void testExecuteForValidInput() throws Exception {
		final int[] numbers = { 1, 2, 3, 4, 5 };

		final Integer result = taskExecuter.execute(numbers);
		assertNotNull(result);
		assertEquals(new Integer(15), result);
	}

}
