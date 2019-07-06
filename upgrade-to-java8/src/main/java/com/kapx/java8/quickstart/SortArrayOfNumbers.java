package com.kapx.java8.quickstart;

import java.util.Arrays;

public class SortArrayOfNumbers {
    public static void main(String[] args) {
        sortNumbersJava7();
        System.out.println("\n--------------------------------");
        sortNumbersJava8();
    }

    private static void sortNumbersJava7() {
        final int[] numbers = {4, 7, 5, 3, 9, 6, 1, 8, 2};
        print("Java7 Before", numbers);
        final int SIZE = numbers.length;
        for (int i = 0; i < SIZE; i++) {
            boolean swap = false;
            for (int j = 0; j < SIZE - 1; j++) {
                swap = swapElements(numbers, swap, j);
            }
            if (!swap) {
                break;
            }
        }
        print("\nJava7 After", numbers);
    }

    private static boolean swapElements(int[] numbers, boolean swap, int index) {
        if (numbers[index] > numbers[index + 1]) {
            final int temp = numbers[index];
            numbers[index] = numbers[index + 1];
            numbers[index + 1] = temp;
            swap = true;
        }
        return swap;
    }

    private static void sortNumbersJava8() {
        final int[] numbers = {4, 7, 5, 3, 9, 6, 1, 8, 2};
        print("Java8 Before", numbers);
        print("\nJava8 After", Arrays.stream(numbers).sorted().toArray());
        // make a scenario of filter
    }

    private static void print(final String prefix, final int[] numbers) {
        System.out.println(prefix);
        Arrays.stream(numbers).forEach(System.out::print);
    }
}
