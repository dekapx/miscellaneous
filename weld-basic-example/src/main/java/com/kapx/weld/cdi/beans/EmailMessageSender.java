package com.kapx.weld.cdi.beans;

import javax.enterprise.event.Observes;

import com.kapx.weld.cdi.events.SampleEvent;

public class EmailMessageSender implements MessageSender {

	private String msg = "default-state-EmailMessageSender";

	public EmailMessageSender() {
	}

	public EmailMessageSender(String msg) {
		this.msg = msg;
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending email message \t" + msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void consumeEvent(@Observes SampleEvent event) throws InterruptedException {
		System.out.println("[EmailMessageSender] event received... " + event.getType());
	}

}
