package com.kapx.testdriven.jmockit.mockstatic.mockstatic;

public class HelloWorld {
    public String sayHello(final String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument must not be null or empty.");
        }

        return StringUtil.format(arg);
    }
}
