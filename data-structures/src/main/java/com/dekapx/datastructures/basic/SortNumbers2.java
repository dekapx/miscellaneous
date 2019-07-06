package com.dekapx.datastructures.basic;

public class SortNumbers2 {
    public static void main(String[] args) {
        final int[] numbers = {57, 48, 79, 65, 15, 33, 52};
        printArray("Before: ", numbers);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                swapPositions(numbers, j);
            }
        }

        printArray("\nAfter: ", numbers);
    }

    private static void swapPositions(int[] numbers, int index) {
        if (numbers[index] > numbers[index + 1]) {
            int temp = numbers[index];
            numbers[index] = numbers[index + 1];
            numbers[index + 1] = temp;
        }
    }

    private static void printArray(final String prefix, final int[] numbers) {
        System.out.println(prefix);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
