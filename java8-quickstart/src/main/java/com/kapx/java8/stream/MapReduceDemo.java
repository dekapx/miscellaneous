package com.kapx.java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MapReduceDemo {
    public static void main(String[] args) {
        final List<String> languages = Arrays.asList("Java", "Scala", "Closure", "Python", "Haskall");
        final String[] elements = languages.stream()
                .filter(l -> l.equals("Scala"))
                .map(l -> l.toUpperCase())
                .toArray(String[]::new);

        System.out.println(elements[0]);
    }

    private static void mapReduceSumExample() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }
}
