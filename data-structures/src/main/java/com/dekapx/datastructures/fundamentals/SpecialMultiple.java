package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SpecialMultiple {
    private static Consumer<Scanner> consumer = (scanner) -> {
        final int nextNumber = scanner.nextInt();
        boolean found = false;
        long occurence = 0;
        int counter = 1;
        while (!found) {
            String binaryString = Integer.toBinaryString(counter);
            occurence = 9 * Long.parseLong(binaryString);
            if (occurence % nextNumber == 0) found = true;
            counter++;
        }
        System.out.println(occurence);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();

        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}
