package com.kapx.java8.quickstart;

import java.util.Arrays;

public class ForLoopOnArray {
    public static void main(String[] args) {
        final int[] numbers = {1, 2, 3, 4, 5};
        forLoopJava7(numbers);
        System.out.println("\n----------");
        forLoopJava8(numbers);
    }

    private static void forLoopJava7(final int[] numbers) {
        for(int number : numbers) {
            System.out.print(number);
        }
    }

    private static void forLoopJava8(final int[] numbers) {
        Arrays.stream(numbers).forEach(System.out::print);
    }
}
