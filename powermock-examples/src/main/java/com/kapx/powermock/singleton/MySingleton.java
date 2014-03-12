package com.kapx.powermock.singleton;

public class MySingleton {
	private static final MySingleton INSTANCE = new MySingleton();

	public static MySingleton getInstance() {
		return INSTANCE;
	}

	public String sayHello(final String arg) {
		if (arg == null || arg.isEmpty()) {
			throw new IllegalArgumentException("Argument must not be null.");
		}

		return "Hello " + arg;
	}
}
