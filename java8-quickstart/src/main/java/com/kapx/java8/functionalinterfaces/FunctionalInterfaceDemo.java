package com.kapx.java8.functionalinterfaces;

// define functional interface
@FunctionalInterface
interface HelloWorld {
    String sayHello(String arg);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // instantiate functional interface
        final HelloWorld object = (final String arg) -> {
            return "Hello ! " + arg;
        };
        final HelloWorld object2 = (arg) -> {
            return ("Hello ! " + arg).toUpperCase();
        };

        // invoke functional interface
        System.out.println(object.sayHello("Java 8"));
        System.out.println(object2.sayHello("Java 8"));
    }
}
