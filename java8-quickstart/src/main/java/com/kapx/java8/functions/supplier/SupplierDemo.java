package com.kapx.java8.functions.supplier;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        final Supplier<String> supplier = () -> {
            return "Hello World";
        };

        System.out.println(supplier.get());
    }
}
