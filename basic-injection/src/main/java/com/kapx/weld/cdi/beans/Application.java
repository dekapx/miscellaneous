package com.kapx.weld.cdi.beans;

import javax.inject.Inject;

public class Application {
	@Inject
	private Service service;

	public Application() {
	}

	public void execute() {
		service.sayHello();
	}
}
