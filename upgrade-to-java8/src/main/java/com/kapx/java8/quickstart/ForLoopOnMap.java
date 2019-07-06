package com.kapx.java8.quickstart;

import java.util.HashMap;
import java.util.Map;

public class ForLoopOnMap {
    public static void main(String[] args) {
        final Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "One");
        numbers.put(2, "Two");
        numbers.put(3, "Three");

        forLoopJava7(numbers);
        System.out.println("\n----------");
        forLoopJava8(numbers);
    }

    private static void forLoopJava7(final Map<Integer, String> numbers) {
        for (Map.Entry<Integer, String > entry : numbers.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void forLoopJava8(final Map<Integer, String> numbers) {
        // example one
        numbers.forEach((k,v) -> {
            System.out.println(k + " : " + v);
        });

        // example two
        numbers.forEach((k,v) -> System.out.println(k + " : " + v));
    }
}
