package com.kapx.java.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoinArrayElements {
    public static void main(String[] args) {
        final String[] languages = {"Java", "Scala", "Kotlin"};
        final String output = arrayAsCommaSeperatedString(languages);
        System.out.println(output);
    }

    /**
     * Return comma seperated String by joining an array.
     */
    private static String arrayAsCommaSeperatedString(final String[] elements) {
        return Arrays
                .stream(elements)
                .collect(Collectors.joining(","));
    }
}
