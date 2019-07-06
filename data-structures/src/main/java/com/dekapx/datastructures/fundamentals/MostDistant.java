package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class MostDistant
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();        // # of dots
        long xMin = Long.MAX_VALUE;  // min x
        long xMax = Long.MIN_VALUE;  // max x
        long yMin = Long.MAX_VALUE;  // min y
        long yMax = Long.MIN_VALUE;  // max y
        for (int a0 = 0; a0 < N; a0++)
        {
            long x = in.nextLong();  // x coordinate
            long y = in.nextLong();  // y coordinate
            if (x < xMin)
            {
                xMin = x;
            }
            if (x > xMax)
            {
                xMax = x;
            }
            if (y < yMin)
            {
                yMin = y;
            }
            if (y > yMax)
            {
                yMax = y;
            }
        }
        double diff = 0.0;  // max diff between coordinates
        diff = Math.max(diff, Math.abs(xMax - xMin));
        diff = Math.max(diff, Math.abs(yMax - yMin));
        diff = Math.max(diff, Math.sqrt(Math.pow(yMin, 2) +
                Math.pow(xMin, 2)));
        diff = Math.max(diff, Math.sqrt(Math.pow(yMax, 2) +
                Math.pow(xMin, 2)));
        diff = Math.max(diff, Math.sqrt(Math.pow(yMin, 2) +
                Math.pow(xMax, 2)));
        diff = Math.max(diff, Math.sqrt(Math.pow(yMax, 2) +
                Math.pow(xMax, 2)));
        System.out.printf("%.12f", diff);
    }
}
