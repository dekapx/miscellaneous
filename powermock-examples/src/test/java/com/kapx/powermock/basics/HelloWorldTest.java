package com.kapx.powermock.basics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
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

	@Test(expected = IllegalArgumentException.class)
	public void testSayHelloForNull() {
		helloWorld.sayHello(null);
	}

	@Test
	public void testSayHelloForValidArg() {
		final String actual = helloWorld.sayHello("Kapx");
		assertNotNull(actual);
		assertEquals("Hello Kapx", actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDisplayMessageForNull() {
		helloWorld.displayMessage(null);
	}

	@Test
	public void testDisplayMessageForValidMsg() {
		final Message mockedMessage = mock(Message.class);
		when(mockedMessage.getMsg()).thenReturn("test-message");
		Message expected = helloWorld.displayMessage(mockedMessage);
	}
}
