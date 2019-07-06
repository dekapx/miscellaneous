package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamSortArrayToList {
    public static void main(String[] args) {
        final String[] elements = {"Java", "Scala", "Kotlin", "Closure", "Python"};
    }

    private static List<String> asSortedList(final String[] elements) {
        return Arrays
                .stream(elements)
                .sorted()
                .collect(Collectors.toList());
    }

    private static void print(final List<String> elements) {
        elements.forEach(print);
    }

    private static Consumer<String> print = (element) -> {
        System.out.println(element);
    };
}
