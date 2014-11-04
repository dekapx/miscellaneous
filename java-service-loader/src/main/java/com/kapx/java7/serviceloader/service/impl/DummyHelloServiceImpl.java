package com.kapx.java7.serviceloader.service.impl;

import com.kapx.java7.serviceloader.service.HelloService;

public class DummyHelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String arg) {
		return "Dummy Hello !!! " + arg;
	}

}
