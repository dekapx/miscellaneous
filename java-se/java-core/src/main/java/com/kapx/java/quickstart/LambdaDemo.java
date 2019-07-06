package com.kapx.java.quickstart;

@FunctionalInterface
interface Hello {
    String sayHello(String arg);
}

public class LambdaDemo {
    public static void main(String[] args) {
        Hello hello = (arg) -> {
            return "Hello ! " + arg;
        };

        print(hello);
    }


    private static void print(Hello hello) {
        System.out.println(hello.sayHello("Java"));
    }
}
