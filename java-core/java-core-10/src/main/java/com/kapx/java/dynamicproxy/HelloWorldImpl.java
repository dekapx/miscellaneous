package com.kapx.java.dynamicproxy;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(final String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument must not be null or empty");
        }
        return "Hello ! " + arg;
    }
}
