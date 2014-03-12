package com.kapx.weld.cdi.beans;

import javax.inject.Inject;

public class World {

	@Inject
	@MessageTransport(MessageTransportType.EMAIL)
	private MessageSender messageSender;

	public String sayWorld() {
		messageSender.sendMessage();

		return "World !!!";
	}
}
