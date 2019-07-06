package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class HalloweenParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int a0 = 0; a0 < T; a0++) {
            long k = in.nextLong();   // total # of cuts
            long vLines = k / 2;      // vertical lines
            long hLines = k - vLines; // horizontal lines
            System.out.println(hLines * vLines);
        }
    }
}
