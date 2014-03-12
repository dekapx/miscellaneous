package com.ericsson.cdi.singleton;

public class MySingleton3 {
    private static MySingleton3 instance;

    private MySingleton3() {
        System.out.println("MySingleton instance created...");
    }

    public static MySingleton3 getInstamce() {
        if (instance == null) {
            synchronized (MySingleton3.class) {
                if (instance == null) {
                    instance = new MySingleton3();
                }
            }
        }

        return instance;
    }

    public void helloWorld() {
        System.out.println("hello singleton");
    }
}
