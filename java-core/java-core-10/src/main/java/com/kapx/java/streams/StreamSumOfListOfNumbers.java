package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;

public class StreamSumOfListOfNumbers {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        /* -- sum of numbers greater then 2 -- */
        final int sum = numbers.stream().filter(i -> i > 2).mapToInt(i -> i).sum();
        System.out.println("Total: " + sum);

    }
}
