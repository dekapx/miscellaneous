package com.kapx.camel.filecomponent;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;

public class MoveFileRouteTest extends CamelTestSupport {

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new MoveFileRoute();
	}

	@EndpointInject(uri = "mock:file:target")
	private MockEndpoint mockResult;

	@Produce(uri = "direct:start")
	protected ProducerTemplate start;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
			@Override
			public void configure() throws Exception {
				replaceFromWith("direct:start");
				mockEndpointsAndSkip("file:*");
			}
		});
	}

	@Test
	public void messageReachesTarted() throws Exception {
		mockResult.expectedBodiesReceived("Test message");

		start.sendBody("Test message");
		mockResult.assertIsSatisfied();
	}
}
