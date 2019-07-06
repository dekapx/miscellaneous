package com.kapx.java.basics;

public class ImplementationForDefaultMethods implements InterfaceWithDefaultMethods {
    public static void main(String[] args) {
        final InterfaceWithDefaultMethods object = new ImplementationForDefaultMethods();
        System.out.println(object.sayHello());
    }
}
