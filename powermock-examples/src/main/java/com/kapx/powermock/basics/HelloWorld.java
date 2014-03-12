package com.kapx.powermock.basics;

public class HelloWorld {
	public String sayHello(final String arg) {
		if (arg == null || arg.isEmpty()) {
			throw new IllegalArgumentException("Argument must not be null.");
		}

		return "Hello " + arg;
	}

	public Message displayMessage(final Message message) {
		if (message == null) {
			throw new IllegalArgumentException("Message must not be null.");
		}

		final String msg = message.getMsg();
		System.out.println("Message is : " + msg);

		message.setMsg("modified " + msg);

		return message;
	}
}
