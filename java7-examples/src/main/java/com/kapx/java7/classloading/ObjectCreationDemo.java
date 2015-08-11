package com.kapx.java7.classloading;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class HelloWorld {
	public HelloWorld() {
	}

	public String sayHello(final String arg) {
		return "Hello !!! " + arg;
	}
}

public class ObjectCreationDemo {

	public void loadClassUsingClassLoader() {
		final String className = "com.kapx.java7.classloading.HelloWorld";
		final ClassLoader classLoader = ObjectCreationDemo.class.getClassLoader();

		try {
			HelloWorld helloWorld = (HelloWorld) classLoader.loadClass(className).newInstance();
			System.out.println(helloWorld.sayHello("kapx"));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public void loadClassUsingReflection() {
		final Class<HelloWorld> clazz = HelloWorld.class;
		final Constructor<?> constructor = clazz.getConstructors()[0];
		try {
			final HelloWorld helloWorld = (HelloWorld) constructor.newInstance();
			System.out.println(helloWorld.sayHello("kapx"));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		final ObjectCreationDemo demo = new ObjectCreationDemo();
		demo.loadClassUsingClassLoader();
		demo.loadClassUsingReflection();

	}
}
