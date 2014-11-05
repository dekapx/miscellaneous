package com.kapx.weld.cdi.beans;

import javax.inject.Inject;

import com.kapx.weld.cdi.util.MessageFormatter;

public class HelloWorldImpl implements HelloWorld {
	@Inject
	private MessageFormatter formatter;

	@Override
	public String sayHello(String arg) {
		return formatter.format(arg);
	}

}
