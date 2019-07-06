package com.kapx.java.optional;

import java.util.Optional;

public class OptionalOrElseDemo {
    public static void main(String[] args) {
        printMessage(null);
        printMessage("Test Message");
    }

    /**
     * if argument is null it will print empty else argument
     */
    private static void printMessage(final String message) {
        final Optional<String> optional = Optional.ofNullable(message);
        System.out.println(optional.orElse(""));
    }
}
