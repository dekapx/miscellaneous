package com.kapx.java.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoinStrings {
    public static void main(String[] args) {
        final String separator = "-";
        final String[] strings = {"Jeet", "Kune", "Do"};
        final String result = joinStrings(separator, strings);
        System.out.println(result);
    }

    public static String joinStrings(final String separator, final String... args) {
        final Stream<String> stream = Stream.of(args);
        return stream.map(String::trim).collect(Collectors.joining(separator));
    }
}
