package com.kapx.java8.quickstart;

import java.util.Arrays;

public class FindMaxNumber {
    public static void main(String[] args) {
        final int[] numbers = {4, 7, 5, 3, 9, 6, 1, 8, 2};
        System.out.println("Max (Java7): " + findMaxJava7(numbers));
        System.out.println("Max (Java8): " + findMaxJava8(numbers));
    }

    private static int findMaxJava7(final int[] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    private static int findMaxJava8(final int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }


}
