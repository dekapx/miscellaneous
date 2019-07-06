package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numberOfTests = scanner.nextInt();

        while (numberOfTests > 0) {
            int length = scanner.nextInt();
            int breadth = scanner.nextInt();
            int gcd = performCut(length, breadth);
            int numberOfSquares = (length / gcd) * (breadth / gcd);
            System.out.println(numberOfSquares);
        }

        scanner.close();
    }

    private static int performCut(int length, int breadth) {
        return (length % breadth == 0) ? breadth : performCut(breadth, length % breadth);
    }
}
