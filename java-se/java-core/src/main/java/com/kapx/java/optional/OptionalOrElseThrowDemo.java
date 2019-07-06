package com.kapx.java.optional;

import java.util.Optional;

public class OptionalOrElseThrowDemo {
    public static void main(String[] args) {
        printMessage("Test Message");
        printMessage(null);
    }

    private static void printMessage(final String message) {
        final Optional<String> optional = Optional.ofNullable(message);
        System.out.println(optional.orElseThrow(NotFoundException::new));
    }
}
