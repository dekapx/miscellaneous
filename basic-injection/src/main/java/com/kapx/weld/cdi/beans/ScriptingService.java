package com.kapx.weld.cdi.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@ApplicationScoped
public class ScriptingService {

	@Inject
	@Any
	TestService testService;

	public void sayHello() {
		System.out.println("ScriptingService.sayHello()!");

		testService.sayHello();
	}

}
