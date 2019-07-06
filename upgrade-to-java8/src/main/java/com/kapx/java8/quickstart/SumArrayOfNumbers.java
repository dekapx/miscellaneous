package com.kapx.java8.quickstart;

import java.util.Arrays;

public class SumArrayOfNumbers {
    public static void main(String[] args) {
        final int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Result (Java 7): " + sumJava7(numbers));
        System.out.println("Result (Java 8): " + sumJava8(numbers));
    }

    private static int sumJava7(final int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

    private static int sumJava8(final int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
