package com.kapx.java7.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

	public String sayHello(final String arg) {
		LOG.info("input [ {} ] received", arg);
		return "Hello !!! " + arg;
	}
}
