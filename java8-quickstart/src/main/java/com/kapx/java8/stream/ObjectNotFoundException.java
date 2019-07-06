package com.kapx.java8.stream;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(final String objectName) {
        super(objectName + " not found!");
    }
}
