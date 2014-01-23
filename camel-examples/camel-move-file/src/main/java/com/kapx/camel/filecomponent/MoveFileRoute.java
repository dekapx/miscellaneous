package com.kapx.camel.filecomponent;

import org.apache.camel.builder.RouteBuilder;

public class MoveFileRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://source").to("log://com.kapx.camel.filecomponent?showAll=true&multiline=true").to("file://target");
	}

}
