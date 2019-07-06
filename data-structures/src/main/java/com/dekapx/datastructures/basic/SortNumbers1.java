package com.dekapx.datastructures.basic;

public class SortNumbers1 {
    public static void main(String[] args) {
        final int[] numbers = { 57, 48, 79, 65, 15, 33, 52 };
        printArray("Before: ", numbers);
        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            int pos = 0;
            boolean flag = false;
            for (int j = i; j < numbers.length; j++) {
                if (isSmallerNumber(numbers, min, j)) {
                    min = numbers[j];
                    pos = j;
                    flag = true;
                }
            }
            if (flag) {
                swapPositions(numbers, min, pos, i);
            }
        }

        printArray("\nAfter: ", numbers);
    }

    private static boolean isSmallerNumber(final int[] numbers, int min, int index) {
        return numbers[index] < min;
    }

    private static void swapPositions(int[] numbers, int min, int pos, int index) {
        final int temp = numbers[index];
        numbers[index] = min;
        numbers[pos] = temp;
    }

    private static void printArray(final String prefix, final int[] numbers) {
        System.out.println(prefix);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
