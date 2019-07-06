package com.dekapx.datastructures.basic;

public class FindMin {
    public static void main(String[] args) {
        final int[] numbers = {15, 48, 79, 65, 57, 33, 52};

        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }

        System.out.println("Min: " + min);
    }
}
