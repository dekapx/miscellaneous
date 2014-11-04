package com.kapx.java7.serviceloader.service.impl;

import com.kapx.java7.serviceloader.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(final String arg) {
		return "Hello !!! " + arg;
	}

}
