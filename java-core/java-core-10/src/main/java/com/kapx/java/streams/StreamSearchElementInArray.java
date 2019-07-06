package com.kapx.java.streams;

import java.util.Arrays;

public class StreamSearchElementInArray {
    public static void main(String[] args) throws Exception {
        final String[] elements = {"Java", "Scala", "Kotlin", "Closure", "Python"};

        System.out.println(search(elements,"Kotlin"));
        System.out.println(search(elements,null));
    }

    private static String search(final String[] elements, final String text) {
        return Arrays.stream(elements)
                .filter(x -> x.equals(text))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Object Not Found..."));
    }
}
