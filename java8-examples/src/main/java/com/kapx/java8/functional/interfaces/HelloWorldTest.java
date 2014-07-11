package com.kapx.java8.functional.interfaces;

public class HelloWorldTest {
	public static void main(String[] args) {
		HelloWorld helloWorld = (arg) -> {
			return "Hello !!! " + arg;
		};

		final String output = helloWorld.sayHello("DeKapx");
		System.out.println(output);
	}
}
