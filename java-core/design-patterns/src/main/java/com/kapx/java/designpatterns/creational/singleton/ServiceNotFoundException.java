package com.kapx.java.designpatterns.creational.singleton;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(final String message) {
        super(message);
    }
}
