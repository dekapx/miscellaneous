package com.kapx.weld.cdi.example;

import static junit.framework.Assert.assertEquals;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.kapx.weld.cdi.beans.Hello;

public class HelloTest {

	@Test
	public void shouldDisplayHelloWorld() {
		WeldContainer weld = new Weld().initialize();
		Hello hello = weld.instance().select(Hello.class).get();
		assertEquals("should say Hello World !!!", "Hello World !!!", hello.sayHelloWorld());
	}
}
