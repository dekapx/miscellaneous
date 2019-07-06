package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MaximumDraws {
    private static Consumer<Scanner> consumer = (scanner) -> {
        final int pairs = scanner.nextInt();
        System.out.println(pairs + 1);
    };
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i-> consumer.accept(scanner));
        scanner.close();
    }
}
