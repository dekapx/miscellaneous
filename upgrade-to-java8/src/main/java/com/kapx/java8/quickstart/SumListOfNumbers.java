package com.kapx.java8.quickstart;

import java.util.Arrays;
import java.util.List;

public class SumListOfNumbers {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("Result (Java 7): " + sumJava7(numbers));
        System.out.println("Result (Java 8): " + sumJava8(numbers));
    }

    private static int sumJava7(final List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    private static int sumJava8(final List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
