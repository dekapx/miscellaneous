package com.kapx.java7.mockito.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldTest {
	private HelloWorld helloWorld;

	private static final String msg = "test message";

	@Mock
	private MsgFormatter mockedMsgFormatter;

	@Before
	public void setUp() throws Exception {
		helloWorld = new HelloWorldStub();
		MockitoAnnotations.initMocks(this);
		Mockito.when(mockedMsgFormatter.format(msg)).thenReturn("!!!!!" + msg + "!!!!!");
	}

	@After
	public void tearDown() throws Exception {
		helloWorld = null;
	}

	@Test
	public void testSayHello() {
		helloWorld.sayHello(msg);
		Mockito.verify(mockedMsgFormatter, Mockito.times(1)).format(msg);
	}

	class HelloWorldStub extends HelloWorld {
		@Override
		protected MsgFormatter getFormatter() {
			return mockedMsgFormatter;
		}
	}
}
