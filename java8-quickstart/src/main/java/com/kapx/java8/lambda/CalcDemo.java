package com.kapx.java8.lambda;

@FunctionalInterface
interface Calc<T, R> {
    R sum(T x, T y);
}

public class CalcDemo {
    public static void main(String[] args) {
        final Calc<Long, Long> calc = (x, y) -> {
            return (x + y);
        };

        System.out.println(calc.sum(5L, 7L));
    }
}
