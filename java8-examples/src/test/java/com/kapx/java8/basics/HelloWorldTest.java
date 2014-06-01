package com.kapx.java8.basics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
	private HelloWorld helloWorld;

	@Before
	public void setUp() throws Exception {
		helloWorld = new HelloWorld();
	}

	@After
	public void tearDown() throws Exception {
		helloWorld = null;
	}

	@Test
	public void testSayHello() {
		final String actualValue = helloWorld.sayHello("Kapx");
		assertNotNull(actualValue);

		final String expectedValue = "Hello !!! Kapx";
		assertEquals(expectedValue, actualValue);
	}

}
