package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConnectingTowns {
    private static final int MOD_VALUE = 1234567;

    private static Consumer<Scanner> consumer = (scanner) -> {
        int l = scanner.nextInt();
        int routes = 1;
        for (int j = 0; j < l - 1; j++) {
            routes *= scanner.nextInt();
            routes %= MOD_VALUE;
        }
        System.out.println(routes);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();

        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}

