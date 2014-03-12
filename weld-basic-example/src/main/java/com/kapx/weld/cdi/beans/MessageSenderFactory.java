package com.kapx.weld.cdi.beans;

import java.io.Serializable;

import javax.enterprise.inject.Produces;

import com.kapx.weld.serviceloader.manager.ServiceManager;

public class MessageSenderFactory implements Serializable {

	private static final long serialVersionUID = -3307659323826155517L;

	@Produces
	@MessageTransport(MessageTransportType.EMAIL)
	public MessageSender getEmailMessageSender() {
		MessageSender messageSender = new EmailMessageSender("modified-object-state");
		return messageSender;
	}

	@Produces
	@MessageTransport(MessageTransportType.SMS)
	public MessageSender getSmsMessageSender() {
		ServiceManager serviceManager = ServiceManager.getInstance();
		MessageSender messageSender = serviceManager.getService(SmsMessageSender.class);
		((SmsMessageSender) messageSender).setMsg("modified-sms-message-state");
		return messageSender;
	}

}
