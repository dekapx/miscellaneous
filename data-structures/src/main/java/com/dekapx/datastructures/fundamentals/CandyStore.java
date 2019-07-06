package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class CandyStore {
    private static final int MOD_VALUE = 1000000000;

    private static Consumer<Scanner> consumer = (scanner) -> {
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        final int max = n + k;
        final int[][] matrix = new int[max][max];
        for (int i = 1; i < max; i++) {
            matrix[i][0] = 1;
            matrix[i][i] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
                matrix[i][j] %= MOD_VALUE;
            }
        }
        System.out.println(matrix[n + k - 1][n - 1]);
    };

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();

        IntStream.range(0, numberOfTests).forEach(i -> consumer.accept(scanner));
        scanner.close();
    }
}
