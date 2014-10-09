package com.kapx.java7.basics;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HelloWorldTest {
	private HelloWorld helloWorld;
	
	
	@Before
	public void setup() {
		helloWorld = new HelloWorld();
	}

	@Test
	public void test() {
		assertEquals("Hello !!! KAPX", helloWorld.sayHello("KAPX"));
	}

}
