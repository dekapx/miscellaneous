package com.kapx.java.streams;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void printEvenNumbers() {
        IntStream
                .range(0, 10)
                .filter(evenNumbers())
                .forEach(print);

    }

    private static IntPredicate evenNumbers() {
        return i -> i %2 == 0;
    }

    private static IntConsumer print = (i) -> System.out.print(i + " ");


    public static void main(String[] args) {
        printEvenNumbers();
    }
}
