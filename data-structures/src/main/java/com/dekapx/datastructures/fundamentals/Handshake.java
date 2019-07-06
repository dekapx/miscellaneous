package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Handshake {
    private static Consumer<Scanner> consumer = (scanner) -> {
        int directors = scanner.nextInt();
        int handshakes = IntStream.range(0, directors).sum();
        System.out.println(handshakes);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();
        IntStream.range(0, numberOfTests).forEach(i-> consumer.accept(scanner));
        scanner.close();
    }

}
