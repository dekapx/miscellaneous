package com.kapx.eai.camel.filecomponent;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopier {
	public static void main(String args[]) throws Exception {
		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:data/input?noop=true").to("file:data/output");
			}
		});

		context.start(); // start the route and let it do its work
		Thread.sleep(10000);

		context.stop(); // stop the CamelContext
	}
}
