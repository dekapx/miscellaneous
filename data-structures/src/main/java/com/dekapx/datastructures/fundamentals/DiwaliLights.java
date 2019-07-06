package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@FunctionalInterface
interface Divisor {
    long divide(long value);
}

public class DiwaliLights {
    private static final int MOD_VALUE = 100000;

    private static Divisor divisor = (value) -> {
        return (value * 2) % MOD_VALUE;
    };

    private static Consumer<Scanner> consumer = (scanner) -> {
        int nextValue = scanner.nextInt();
        long result = 2;

        for (int i = 1; i < nextValue; i++)
        {
            result = divisor.divide(result);
        }
        result--;
        System.out.println(result);
    };


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();

        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}

