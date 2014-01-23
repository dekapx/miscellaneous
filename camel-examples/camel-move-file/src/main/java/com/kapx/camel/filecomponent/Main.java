package com.kapx.camel.filecomponent;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
	public static void main(String[] args) throws Exception {
		final CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new MoveFileRoute());
		camelContext.setTracing(true);
		camelContext.start();

		Thread.sleep(100000);

		camelContext.stop();
	}
}
