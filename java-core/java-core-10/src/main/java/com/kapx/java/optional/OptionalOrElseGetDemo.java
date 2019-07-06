package com.kapx.java.optional;

import java.util.Optional;

public class OptionalOrElseGetDemo {
    public static void main(String[] args) {
        printMessage(null);
        printMessage("Test Message");
    }

    private static void printMessage(final String message) {
        final Optional<String> optional = Optional.ofNullable(message);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }
}
