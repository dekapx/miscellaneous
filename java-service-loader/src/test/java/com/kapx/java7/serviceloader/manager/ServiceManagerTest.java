package com.kapx.java7.serviceloader.manager;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kapx.java7.serviceloader.service.HelloService;
import com.kapx.java7.serviceloader.service.impl.HelloServiceImpl;

public class ServiceManagerTest {
	private ServiceManager serviceManager;
	
	@Before
	public void setup() {
		serviceManager = ServiceManager.getInstance();
	}

	@Test
	public void test() {
		serviceManager = ServiceManager.getInstance();
		
		HelloService helloService = serviceManager.getService(HelloServiceImpl.class);
		assertEquals("Hello !!! Kapx", helloService.sayHello("Kapx"));
		
		HelloServiceImpl helloServiceImpl = serviceManager.getService(HelloServiceImpl.class);
		assertEquals("Hello !!! Kapx", helloServiceImpl.sayHello("Kapx"));
	}
}
