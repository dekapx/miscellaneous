package com.dekapx.datastructures.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class BusStation {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int[] sums = new int[numberOfTests];
        int max = 0;
        for (int i = 0; i < numberOfTests; i++) {
            int a = scanner.nextInt();
            max += a;
            sums[i] = max;
        }
        for (int x : sums) {
            if (max % x == 0) {
                boolean valid = true;
                for (int k = 1; valid && k*x <= max; k++) {
                    int idx = Arrays.binarySearch(sums, k*x);
                    if (idx < 0)
                        valid = false;
                }
                if (valid)
                    System.out.print(x + " ");
            }
        }

    }
}
