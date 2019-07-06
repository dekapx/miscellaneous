package com.kapx.java8.basics;

@FunctionalInterface
interface Calc {
    int sum(int x, int y);
}


public class LambdaCalcDemo {
    public static void main(String[] args) {
        final LambdaCalcDemo demo = new LambdaCalcDemo();
        // example 1
        final Calc calc = (int x, int y) -> {
            return x + y;
        };

        int result = calc.sum(5, 7);
        System.out.println(result);

        // example 2
        final Calc calc2 = (x, y) -> x + y;

        result = calc2.sum(5, 7);
        System.out.println(result);
    }
}
