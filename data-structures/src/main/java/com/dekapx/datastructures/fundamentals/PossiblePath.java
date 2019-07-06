package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class PossiblePath {
    private static long calcReverseCommon(long a, long b) {
        return b == 0 ? a : calcReverseCommon(b, a % b);
    }

    private static Consumer<Scanner> consumer = (scanner) -> {
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        if (calcReverseCommon(a, b) == calcReverseCommon(x, y)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}
