package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class FillingJars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();  // # of candy jars
        int M = in.nextInt();  // # of operations
        long total = 0;        // total # of candies
        for (int a0 = 0; a0 < M; a0++)
        {
            long a = in.nextInt();  // left index
            long b = in.nextInt();  // right index
            long k = in.nextInt();  // # of candies
            total += (b - a + 1) * k;
        }
        System.out.println(total / N);
    }
}
