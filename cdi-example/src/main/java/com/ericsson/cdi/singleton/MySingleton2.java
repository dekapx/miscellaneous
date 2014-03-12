package com.ericsson.cdi.singleton;

public class MySingleton2 {
    private static final MySingleton2 instance = new MySingleton2();

    private MySingleton2() {
        System.out.println("MySingleton instance created...");
    }

    public static MySingleton2 getInstamce() {
        return instance;
    }

    public void helloWorld() {
        System.out.println("hello singleton");
    }
}
