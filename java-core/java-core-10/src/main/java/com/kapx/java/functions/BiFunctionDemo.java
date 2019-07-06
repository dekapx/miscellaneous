package com.kapx.java.functions;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        System.out.println(calc.apply(6, 7));
    }

    private static BiFunction<Integer, Integer, Double> calc = (num1, num2) ->
            Double.valueOf(num1 * num2);
}
