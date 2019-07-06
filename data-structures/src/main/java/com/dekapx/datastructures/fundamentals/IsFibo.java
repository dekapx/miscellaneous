package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class IsFibo {
    static boolean isFibonacci(long n) {
        double ans1 = (5 * Math.pow(n, 2)) - 4;
        double ans2 = (5 * Math.pow(n, 2)) + 4;
        if (Math.sqrt(ans1) % 1 == 0 || Math.sqrt(ans2) % 1 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int a0 = 0; a0 < numberOfTests; a0++) {
            long n = scanner.nextLong();
            if (isFibonacci(n)) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }
    }
}
