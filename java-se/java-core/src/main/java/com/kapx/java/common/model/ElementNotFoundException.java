package com.kapx.java.common.model;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException() {
        super("Object Not Found. Please try again...");
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
