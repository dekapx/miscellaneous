package com.kapx.weld.cdi.beans;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestService { // implements Service {

	public void sayHello() {
		System.out.println("TestService.sayHello()!");
	}

}
