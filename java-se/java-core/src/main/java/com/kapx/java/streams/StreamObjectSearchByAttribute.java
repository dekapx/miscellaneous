package com.kapx.java.streams;

import com.kapx.java.common.model.ElementNotFoundException;
import com.kapx.java.common.model.Language;
import com.kapx.java.common.model.LanguageBuilder;
import com.kapx.java.common.model.LanguageType;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamObjectSearchByAttribute {
    public static void main(String[] args) {
        final List<Language> languages = LanguageBuilder.getLanguages();
        System.out.println(getByType(languages, LanguageType.OBJECT_ORIENTED));
        //-----------------------------------------------------------------//
        print(getAllByType(languages, LanguageType.FUNCTIONAL));
        //-----------------------------------------------------------------//
        final List<String> names = getSortedNames(languages);
        names.forEach(printName);
        //-----------------------------------------------------------------//

        //-----------------------------------------------------------------//
    }

    /**
     * Search and return an element in list and throw exception if not found..
     */
    private static Language getByType(final List<Language> languages, final LanguageType type) {
        return languages.stream()
                .filter(l -> l.getType().equals(type))
                .findFirst()
                .orElseThrow(ElementNotFoundException::new);
    }

    /**
     * Search and return the elements from the list.
     */
    private static List<Language> getAllByType(final List<Language> languages, final LanguageType type) {
        return languages.stream()
                .filter(l -> l.getType().equals(type))
                .collect(Collectors.toList());
    }

    /**
     * Return sorted list of names.
     */
    private static List<String> getSortedNames(final List<Language> languages) {
        return languages.stream()
                .map(i -> i.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    private static void print(final List<Language> languages) {
        languages.forEach(printLanguage);
    }

    private static Consumer<Language> printLanguage = (language) -> {
        System.out.println(language);
    };

    private static Consumer<String> printName = (name) -> {
        System.out.print(name + " ");
    };
}
