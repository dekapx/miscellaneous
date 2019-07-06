package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class MutualRecurrences {

    private static Consumer<Scanner> consumer = (scanner) -> {
        while(scanner.hasNext()) {
            int value = scanner.nextInt();
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}