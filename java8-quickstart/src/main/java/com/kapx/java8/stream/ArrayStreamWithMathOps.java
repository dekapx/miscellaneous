package com.kapx.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class ArrayStreamWithMathOps {
    public static void main(String[] args) {
        final int[] numbers = {7, 2, 9, 4, 6, 3, 1, 1, 0, 5, 8, 1, 3};
        sum(numbers);

        average(numbers);

        display(numbers);
    }

    private static void average(int[] numbers) {
        final OptionalDouble optionalDouble = Arrays.stream(numbers).average();
        if (optionalDouble.isPresent()) {
            System.out.println("Average: " + optionalDouble.getAsDouble());
        }
    }

    private static void sum(final int[] numbers) {
        final int sum = Arrays.stream(numbers).sum();
        System.out.println("Total: " + sum);
    }

    private static void display(final int[] numbers) {
        Arrays.stream(numbers).forEach(i -> System.out.print(i + " "));
    }
}
