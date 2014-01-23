package com.kapx.camel.filecomponent;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) throws Exception {
		final AbstractApplicationContext springContext = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");

		springContext.start();
		Thread.sleep(100000);
		springContext.stop();

		springContext.close();
	}
}
