package com.kapx.java.streams;

import java.util.Arrays;
import java.util.List;

public class StreamMathOperations {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(60, 22, 33, 77, 99, 88, 45);
        final int sum = sum(numbers);
        System.out.println("Sum of Numbers: " + sum);

        final int min = min(numbers);
        System.out.println("Min: " + min);

        final int max = max(numbers);
        System.out.println("Max: " + max);

        final long count = count(numbers);
        System.out.println("Count: " + count);

        final double average = average(numbers);
        System.out.println("Average: " + average);
    }

    private static final int sum(final List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).sum();
    }

    private static final int min(final List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).min().getAsInt();
    }

    private static final int max(final List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).max().getAsInt();
    }

    private static final long count(final List<Integer> numbers) {
        return numbers.stream().mapToLong(i -> i).count();
    }

    private static final double average(final List<Integer> numbers) {
        return numbers.stream().mapToInt(i -> i).average().getAsDouble();
    }

}
