package com.dekapx.datastructures.fundamentals;

public class CollectionEquilibrium {
    public static void main(String[] args) {
        final int[] x = {4, 1, 2, 3, 3};
        int value = collectionEquilibrium(x);
        System.out.println(value);
    }


    private static int collectionEquilibrium(int[] x) {
        for (int index = 0; index < x.length; index++) {
            int difference = 0;

            for (int i = index -  1; i > -1; i--) {
                difference += x[i];
            }
            for (int i = index+1; i < x.length; i++) {
                difference -= x[i];
            }

            if (difference == 0) {
                return 1;
            }
        }

        return 0;
    }
}
