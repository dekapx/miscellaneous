package com.ericsson.cdi.singleton;

public enum MySingleton {

    INSTANCE;

    private MySingleton() {
        System.out.println("MySingleton instance created...");
    }

    public void helloWorld() {
        System.out.println("hello singleton");
    }
}
