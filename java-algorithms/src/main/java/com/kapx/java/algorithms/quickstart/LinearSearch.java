package com.kapx.java.algorithms.quickstart;

public class LinearSearch {

    public boolean search(final int[] elements, final int element) {
        boolean flag = false;

        for (int i = 0; i < elements.length; i ++) {
            if (elements[i] == element) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
