package com.kapx.java7.classloading;

class HelloWorld {
	public String sayHello(final String arg) {
		return "Hello !!! " + arg;
	}
}

public class ClassLoaderExample {
	public static void main(String[] args) {
		final String className = "com.kapx.java7.classloading.HelloWorld";
		ClassLoader classLoader = ClassLoaderExample.class.getClassLoader();
		
		try {
			HelloWorld helloWorld = (HelloWorld) classLoader.loadClass(className).newInstance();
			System.out.println(helloWorld.sayHello("kapx"));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
