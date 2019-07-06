package com.kapx.testdriven.quickstart;

import java.util.Arrays;
import java.util.List;

public class HelloWorld {
    public String sayHello(final String arg) {
        if (null == arg || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument must not be null or empty.");
        }

        return "Hello ! " + arg;
    }
}
