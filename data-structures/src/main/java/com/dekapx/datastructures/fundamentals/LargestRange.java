package com.dekapx.datastructures.fundamentals;

public class LargestRange {
    public static void main(String[] args) {
        final int[] arr = {6, 7, 9, 5, 6, 3, 2};
//        final int maxDiff = largestRange(arr);
        final int maxDiff = solution(arr);
        System.out.println(maxDiff);
    }

    private static int solution(int[] x) {
        int largestRange = x[1] - x[0];
        int i, j;
        for (i = 0; i < x.length; i++) {
            for (j = i + 1; j < x.length; j++) {
                if (x[j] - x[i] > largestRange)
                    largestRange = x[j] - x[i];
            }
        }
        return largestRange;
    }


    private static int largestRange(int[] x) {
        int maxDiff = Integer.MIN_VALUE, minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < x.length; i++) {
            if (minNumber > x[i])
                minNumber = x[i];

            maxDiff = Math.max(maxDiff, (x[i] - minNumber));
        }
        return maxDiff;
    }
}
