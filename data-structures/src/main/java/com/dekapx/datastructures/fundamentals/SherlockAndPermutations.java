package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SherlockAndPermutations {
    private static final int MOD_VALUE = 1000000007;

    private static Consumer<Scanner> consumer = (scanner) -> {
        int zeros = scanner.nextInt();
        int ones = scanner.nextInt();

        int maxLength = ones + zeros;

        int[][] matrix = new int[maxLength][maxLength];
        for (int i = 1; i < maxLength; i++) {
            matrix[i][0] = 1;
            for (int j = 1; j < maxLength; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                matrix[i][j] %= MOD_VALUE;
            }
        }
        System.out.println(matrix[ones][zeros]);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}
