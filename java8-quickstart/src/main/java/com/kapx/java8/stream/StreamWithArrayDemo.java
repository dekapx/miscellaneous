package com.kapx.java8.stream;

import java.util.Arrays;

public class StreamWithArrayDemo {
    public static int sum(final int... nums) {
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3, 4, 5));
    }
}
