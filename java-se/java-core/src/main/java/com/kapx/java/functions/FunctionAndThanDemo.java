package com.kapx.java.functions;

import java.util.function.Function;

public class FunctionAndThanDemo {
    public static void main(String[] args) {
        final String[] elements = { "Java 10" };
        final String output = extract.andThen(sayHello).andThen(toUpperCase).apply(elements);
        System.out.println(output);
    }

    private static Function<String[], String> extract = (args) -> args[0];

    private static Function<String, String> sayHello = (arg) -> "Hello ! " + arg;

    private static Function<String, String> toUpperCase = (arg) -> arg.toUpperCase();
}
