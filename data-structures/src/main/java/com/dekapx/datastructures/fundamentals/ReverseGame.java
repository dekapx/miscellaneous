package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class ReverseGame {
    public static void main(String[] args) throws Exception {
        final Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int numberOfBalls = in.nextInt();
            int ball = in.nextInt();
            numberOfBalls--;
            if (ball == numberOfBalls / 2) {
                System.out.println(numberOfBalls);
            } else if (ball < numberOfBalls / 2) {
                System.out.println(2 * (ball + 1) - 1);
            } else {
                System.out.println(2 * (numberOfBalls - ball));
            }
        }
    }
}
