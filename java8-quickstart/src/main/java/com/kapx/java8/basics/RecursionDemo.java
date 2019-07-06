package com.kapx.java8.basics;

public class RecursionDemo {
    public static void main(String[] args) {
        final int result = add(1, 5);
        System.out.println("Result: " + result);
    }

    private static int add(int x, int y) {
        return y == 0 ? x : add(++x, --y);
    }
}
