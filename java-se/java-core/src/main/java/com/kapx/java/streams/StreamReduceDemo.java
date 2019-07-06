package com.kapx.java.streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;

public class StreamReduceDemo {
    public static void main(String[] args) {
        final IntBinaryOperator operator =(x, y) -> {
            System.out.println("In accumulator: " + x + "," + y);
                return x + y;
        };

        final int[] numbers = {1, 2, 3, 4, 5};
        final OptionalInt optionalInt  = Arrays.stream(numbers).reduce(operator);

        System.out.println("Result: " + optionalInt.getAsInt());
    }
}
