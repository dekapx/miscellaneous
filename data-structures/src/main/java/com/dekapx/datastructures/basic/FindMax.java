package com.dekapx.datastructures.basic;

public class FindMax {
    public static void main(String[] args) {
        final int[] numbers = {15, 48, 79, 65, 57, 33, 52};

        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }

        System.out.println("Max: " + max);
    }
}
