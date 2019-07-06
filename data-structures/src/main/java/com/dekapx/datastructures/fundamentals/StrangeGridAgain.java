package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class StrangeGridAgain {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final long row = in.nextLong();
        final long column = in.nextLong();
        if (isOddRow(row)) {
            System.out.println(2 * (column - 1) + 5 * (row - 1));
        } else {// even row
            System.out.println(2 * (column - 1) + 5 * (row - 2) + 1);
        }
    }

    private static boolean isOddRow(long row) {
        return row % 2 == 1;
    }

}
