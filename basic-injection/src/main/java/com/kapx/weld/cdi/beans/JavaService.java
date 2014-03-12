package com.kapx.weld.cdi.beans;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JavaService implements Service {

	@Override
	public void sayHello() {
		System.out.println("JavaService.sayHello()!");

		ScriptingService scriptingService = new ScriptingService();
		scriptingService.sayHello();
	}

}
