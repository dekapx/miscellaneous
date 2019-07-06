package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class TheFloatingRocks {
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++)
        {
            long x1 = scanner.nextLong(); // x coordinate of P1
            long y1 = scanner.nextLong(); // y coordinate of P1
            long x2 = scanner.nextLong(); // x coordinate of P2
            long y2 = scanner.nextLong(); // y coordinate of P2
            long xDiff = Math.abs(x1 - x2);
            long yDiff = Math.abs(y1 - y2);
            System.out.println(gcd(xDiff, yDiff) - 1);
        }
    }
}
