package com.kapx.java8.quickstart;

import java.util.Arrays;
import java.util.List;

public class ForLoopOnList {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        forLoopJava7(numbers);
        System.out.println("\n----------");
        forLoopJava8(numbers);
    }

    private static void forLoopJava7(final List<Integer> numbers) {
        for(int number : numbers) {
            System.out.print(number);
        }
    }

    private static void forLoopJava8(final List<Integer> numbers) {
        numbers.forEach(System.out::print);
    }
}
