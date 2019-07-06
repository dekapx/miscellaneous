package com.kapx.java.util.function;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        final BiFunction<Float, Float, Float> area = (width, length) -> width * length;
        final float width = 7.0F;
        final float length = 10.0F;
        final float result = area.apply(width, length);
        System.out.println(result);
    }
}


