package com.kapx.java.optional;

import java.util.Optional;

public class OptionalWithFilterDemo {
    public static void main(String[] args) {
        printMessage("Test Message");
        printMessage("  ");
    }

    private static void printMessage(final String message) {
        final Optional<String> optional = Optional.ofNullable(message);
        System.out.println(optional.filter(msg -> !msg.trim().isEmpty()).orElseThrow(NotFoundException::new));
    }
}
