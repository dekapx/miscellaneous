package com.kapx.java.streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamIterateDemo {
    public static void main(String[] args) {
        Stream.iterate(1, i -> i + 1)
                .limit(10)
                .forEach(print);
    }

    private static Consumer<Integer> print = (i) -> {
        System.out.print(i + " ");
    };
}
