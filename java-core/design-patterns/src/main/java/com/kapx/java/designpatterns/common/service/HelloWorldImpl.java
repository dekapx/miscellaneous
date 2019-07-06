package com.kapx.java.designpatterns.common.service;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument must not be null or empty.");
        }
        return "Hello ! " + arg;
    }
}
