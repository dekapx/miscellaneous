package com.kapx.java.quickstart;

public class HelloWorld {
    public String sayHello(final String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument must not be null or empty.");
        }
        return "Hello ! " + arg;
    }
}
