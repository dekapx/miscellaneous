package com.kapx.java8.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        final String msg = "Hello Java8";
        printMessaageOrElse(msg);
        printMessaageOrElse(null);
    }


    public static void printMessaageOrElse(final String msg) {
        final Optional<String> optionalMsg = Optional.ofNullable(msg);
        final String msgToPrint = optionalMsg.isPresent() ? msg : optionalMsg.orElse("No Value");
        System.out.println(msgToPrint);
    }

    public static void printMessaageOrElseThrow(final String msg) {
        final Optional<String> optionalMsg = Optional.ofNullable(msg);
        System.out.println(optionalMsg.isPresent() ? msg : optionalMsg.orElseThrow(IllegalArgumentException::new));
    }
}
