package com.kapx.java.common.model;

public class Language {
    private String name;
    private LanguageType type;

    public Language (final String name, final LanguageType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public LanguageType getType() {
        return type;
    }

    @Override
    public String toString() {
        final String text = "[ %s - %s ]";
        return String.format(text, getName(), getType());
    }
}
