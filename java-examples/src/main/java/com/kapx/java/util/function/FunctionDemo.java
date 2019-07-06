package com.kapx.java.util.function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        final Function<Integer, Double> milesToKms = (input) -> (1.6 * input);
        final int miles = 65;
        final double kms = milesToKms.apply(miles);
        System.out.printf("%d miles = %3.2f kilometers", miles, kms);
    }
}
