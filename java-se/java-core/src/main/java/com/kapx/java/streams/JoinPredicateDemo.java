package com.kapx.java.streams;

import com.kapx.java.common.model.Person;
import com.kapx.java.common.model.PersonBuilder;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JoinPredicateDemo {
    public static void main(String[] args) {
        final List<Person> persons = filterByNameAndAge("B", 25);
        print(persons);
    }

    private static Predicate<Person> startsWithPredicate(final String startsWith) {
        return p -> p.getFirstName().startsWith(startsWith);
    }

    private static Predicate<Person> ageGraterThanPredicate(final Integer age) {
        return p -> p.getAge() > age;
    }

    private static List<Person> filterByNameAndAge(final String startsWith, final Integer age) {
        final List<Person> persons = PersonBuilder.personList();
        return persons.stream()
                .filter(startsWithPredicate(startsWith).and(ageGraterThanPredicate(age)))
                .collect(Collectors.toList());
    }

    private static void print(final List<Person> persons) {
        persons.forEach(System.out::println);
    }
}
