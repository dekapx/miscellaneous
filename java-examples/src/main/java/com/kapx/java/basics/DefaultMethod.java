package com.kapx.java.basics;

interface HelloWorld {
	String sayHello(String arg);

	default String format(String arg) {
		return "-- " + arg + " --";
	}
}

class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(final String arg) {
		return format("Hello ! " + arg);
	}
}


public class DefaultMethod {
	public static void main(String[] args) {
		final HelloWorld object = new HelloWorldImpl();
		System.out.println(object.sayHello("DeKapx"));
	}
}
