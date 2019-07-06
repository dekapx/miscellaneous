package com.kapx.java.common.model;

import java.util.ArrayList;
import java.util.List;

public class PersonBuilder {
    public static List<Person> personList() {
        final List<Person> persons = new ArrayList<>();
        persons.add(Person.builder().firstName("Darek").lastName("O'Neil").age(35).build());
        persons.add(Person.builder().firstName("Bryan").lastName("Smith").age(27).build());
        persons.add(Person.builder().firstName("Sean").lastName("White").age(45).build());
        persons.add(Person.builder().firstName("Brooke").lastName("Burke").age(25).build());
        persons.add(Person.builder().firstName("Katie").lastName("Brown").age(22).build());
        persons.add(Person.builder().firstName("Aaron").lastName("Tucker").age(33).build());
        persons.add(Person.builder().firstName("Veronica").lastName("Rice").age(18).build());
        persons.add(Person.builder().firstName("James").lastName("Black").age(24).build());
        persons.add(Person.builder().firstName("Bruce").lastName("Wayne").age(28).build());
        return persons;
    }

}
