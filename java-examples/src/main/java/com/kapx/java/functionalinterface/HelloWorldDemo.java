package com.kapx.java.functionalinterface;

@FunctionalInterface
interface HelloWorld {
	void sayHello(String arg);
}

public class HelloWorldDemo {

	public static void main(String[] args) {
		HelloWorld helloWorld = (final String arg) -> {
			System.out.println("Hello !!! " + arg);
		};

		helloWorld.sayHello("Java 8");
	}

}
