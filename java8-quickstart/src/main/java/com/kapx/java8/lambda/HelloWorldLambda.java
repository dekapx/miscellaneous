package com.kapx.java8.lambda;

public class HelloWorldLambda {
    public static void main(String[] args) {
        final HelloWorld helloWorld = new HelloWorld() {
            @Override
            public String sayHello(String arg) {
                return "Hello ! " + arg;
            }
        };

        final HelloWorld helloWorld2 = (String arg) -> {
                return "Hello ! " + arg;
        };

        final HelloWorld helloWorld3 = arg -> "Hello ! " + arg;

        System.out.println(helloWorld.sayHello("Java"));
        System.out.println(helloWorld2.sayHello("Scala"));
        System.out.println(helloWorld3.sayHello("Kotlin"));
    }
}
