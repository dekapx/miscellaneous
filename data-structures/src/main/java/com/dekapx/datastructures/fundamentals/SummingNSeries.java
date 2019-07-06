package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SummingNSeries {
    private static final int MOD_VALUE = 1000000007;

    private static Consumer<Scanner> consumer = (scanner) -> {
        final long nextValue = scanner.nextLong() % MOD_VALUE;
        final long result = (nextValue * nextValue) % MOD_VALUE;
        System.out.println(result);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}
