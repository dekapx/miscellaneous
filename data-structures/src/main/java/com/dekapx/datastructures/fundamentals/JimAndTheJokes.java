package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class JimAndTheJokes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 12 * 3 + 1;  // max date value 12/31
        int N = in.nextInt();  // the number of dates
        long count[] = new long[max];  // the counts of each date
        for (int a0 = 0; a0 < N; a0++) {
            int m = in.nextInt();  // the base (aka the month)
            int d = in.nextInt();  // the day
            if (d / 10 < m && d % 10 < m) {
                int converted = (d / 10) * m + d % 10;
                count[converted - 1]++;
            }
        }
        long total = 0;  // the number of jokes
        for (int i = 0; i < max; i++)
        {
            total += count[i] * (count[i] - 1) / 2;
        }
        System.out.println(total);
    }
}
