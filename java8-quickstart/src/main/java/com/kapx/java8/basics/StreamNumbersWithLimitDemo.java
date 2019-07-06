package com.kapx.java8.basics;

import java.util.Arrays;
import java.util.List;

public class StreamNumbersWithLimitDemo {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .limit(5)   // iterate till 5t index only
                .forEach(System.out::println);
    }
}
