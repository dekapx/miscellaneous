package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class SherlockMovingTiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int firstSquare = scanner.nextInt();
        int secondSquare = scanner.nextInt();
        int numberOfQueries = scanner.nextInt();
        for(int i = 0; i < numberOfQueries; i++) {
            long qi = scanner.nextLong();
            double ans = Math.sqrt(2) * (length - Math.sqrt(qi));
            double diff = Math.abs(secondSquare - firstSquare);
            System.out.println(ans / diff);
        }
    }
}

