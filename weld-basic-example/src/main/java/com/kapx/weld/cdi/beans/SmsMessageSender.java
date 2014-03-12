package com.kapx.weld.cdi.beans;

import javax.enterprise.event.Observes;

import com.kapx.weld.cdi.events.SampleEvent;

public class SmsMessageSender implements MessageSender {

	private String msg = "default-state-SmsMessageSender";

	public SmsMessageSender() {
	}

	public SmsMessageSender(String msg) {
		this.msg = msg;
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending SMS message \t" + msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void consumeEvent(@Observes SampleEvent event) throws InterruptedException {
		System.out.println("[SmsMessageSender] event received... " + event.getType());
	}

}
