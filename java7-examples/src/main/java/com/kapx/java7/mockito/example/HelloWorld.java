package com.kapx.java7.mockito.example;

public class HelloWorld {

	public void sayHello(final String msg) {
		final MsgFormatter msgFormatter = getFormatter();
		System.out.println("Hello " + msgFormatter.format(msg));
	}

	protected MsgFormatter getFormatter() {
		final MessageFormatterProxy proxy = MessageFormatterProxy.INSTANCE;
		return proxy.getMsgFormatter();
	}
}
