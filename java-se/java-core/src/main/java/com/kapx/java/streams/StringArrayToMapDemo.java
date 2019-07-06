package com.kapx.java.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StringArrayToMapDemo {
    public static void main(String[] args) {
        final String[] elements = {"1, One", "2, Two", "3, Three"};
        Map<Integer, String> result = Arrays.stream(elements)
                .map(i -> i.split(", "))
                .collect(Collectors.toMap(entry -> Integer.parseInt(entry[0]), entry -> entry[1]));

        result.entrySet().stream().forEach(print);
    }

    private static Consumer<Map.Entry<Integer, String>> print = (entry) -> {
        System.out.println(entry.getKey() + " - " + entry.getValue());
    };
}
