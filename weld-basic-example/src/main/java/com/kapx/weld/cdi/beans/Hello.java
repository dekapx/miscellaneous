package com.kapx.weld.cdi.beans;

import javax.inject.Inject;

import com.kapx.weld.cdi.events.SampleEvent;

public class Hello {

	@Inject
	World world;

	@Inject
	@MessageTransport(MessageTransportType.SMS)
	private MessageSender messageSender;

	@Inject
	@EventHandler(className = "com.kapx.weld.cdi.beans.CollectionSplitterComponent")
	private EventInputHandler eventInputHandler;

	public String sayHelloWorld() {
		eventInputHandler.handleEvent(new SampleEvent("test"));

		messageSender.sendMessage();

		return "Hello " + world.sayWorld();
	}
}
