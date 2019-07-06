package com.kapx.java.streams;

import com.kapx.java.common.model.Language;
import com.kapx.java.common.model.LanguageBuilder;

import java.util.Comparator;
import java.util.List;

public class SortListWithMethodRef {
    public static void main(String[] args) {
        final List<Language> languages = LanguageBuilder.getLanguages();
        languages.sort(Comparator.comparing(Language::getName));
        printLaguages(languages);
    }

    private static void printLaguages(final List<Language> languages) {
        languages.stream().map(l -> l.getName()).forEach(System.out::println);
    }
}
