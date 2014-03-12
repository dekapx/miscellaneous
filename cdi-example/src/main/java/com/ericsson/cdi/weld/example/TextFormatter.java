package com.ericsson.cdi.weld.example;

import javax.inject.Named;

@Named
public class TextFormatter {
    public String formatText(final String text) {
        return "formatted message " + text;
    }
}
