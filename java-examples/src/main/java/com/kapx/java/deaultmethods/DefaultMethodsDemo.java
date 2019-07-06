package com.kapx.java.deaultmethods;


interface HelloWorld {
    default String sayHello(String arg) {
        return "Hello ! " + arg;
    }

    String format(String arg);
}

public class DefaultMethodsDemo {
    public static void main(String[] args) {
        final HelloWorld helloWorld = new HelloWorld() {
            @Override
            public String format(String arg) {
                return "-- " + arg + " --";
            }
        };

        final String output = helloWorld.sayHello("DeKapx");
        System.out.println(output);
        final String formattedOutput = helloWorld.format(output);
        System.out.println(formattedOutput);
    }
}
