package com.kapx.java8.basics;

import java.util.Arrays;
import java.util.List;

public class ListStreamSumNumbers {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int total = numbers
                .stream()
                .filter(n -> n % 2 == 0)     // filter even numbers
                .mapToInt(n -> n)
                .sum();
        System.out.println(total);
    }
}
