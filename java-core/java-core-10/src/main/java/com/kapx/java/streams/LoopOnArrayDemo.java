package com.kapx.java.streams;

import java.util.Arrays;

public class LoopOnArrayDemo {
    public static void main(String[] args) {
        final String[] elements = {"A", "B", "C"};
        Arrays.stream(elements).forEach((element) -> {
            System.out.println(element);
        });
    }
}
