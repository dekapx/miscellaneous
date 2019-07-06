package com.kapx.testdriven.jmockit.mockstatic.mockstatic;

public class StringUtil {
    public static String format(final String arg) {
        return "! " + arg + " !";
    }

    public static boolean hasWhitespaces(final String arg) {
        return arg.matches(".*\\s+.*");
    }
}
