package com.kapx.java.functions;

interface CustomFunction<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

public class CustomFunctionDemo {
    public static void main(String[] args) {
        System.out.println(sumNums.apply(3, 5, 7));
    }

    private static CustomFunction<Integer, Integer, Integer, Long> sumNums = (n1, n2, n3) -> Long.valueOf(n1 + n2 + n3);


}
