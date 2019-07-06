package com.kapx.java.basics;

public interface InterfaceWithDefaultMethods {
    default String sayHello() {
        return TextFormatter.formatText("Hello");
    }

    class TextFormatter {
        private static String formatText(final String text) {
            return "-- " + text + " --";
        }
    }
}
