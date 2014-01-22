package com.kapx.eai.camel.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelJmsToFile {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false");
		context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("jms:queue:test.in.queue").to("file://test");
			}
		});

		ProducerTemplate template = context.createProducerTemplate();
		context.start();
		for (int i = 0; i < 10; i++) {
			template.sendBody("jms:queue:test.in.queue", "Test Message: " + i);
		}

		// wait a bit and then stop
		Thread.sleep(1000);
		context.stop();
	}
}
