package com.kapx.java8.stream;

import java.util.ArrayList;
import java.util.List;

public class StudentHelper {
    public static List<Student> getAll() {
        final List<Student> students = new ArrayList<>();
        students.add(Student.builder()
                .id(1L).firstName("Sarah").lastName("Jane").grade(Grade.JUNIOR_INFANTS)
                .address(Address.builder()
                        .address1("APT. 4").address2("Strand Court").city("Athlone").county("Westmeath").build())
                .build());
        students.add(Student.builder()
                .id(1L).firstName("Nicole").lastName("Smith").grade(Grade.JUNIOR_INFANTS)
                .address(Address.builder()
                        .address1("APT. 8, The Glebe").address2("CityQuarter").city("Kilcock").county("Kildare").build())
                .build());
        students.add(Student.builder()
                .id(1L).firstName("Steve").lastName("Austin").grade(Grade.FIFTH)
                .address(Address.builder()
                        .address1("APT. 15, ParkGrove").address2("CityQuarter").city("Galway").county("Galway").build())
                .build());
        students.add(Student.builder()
                .id(1L).firstName("Aaron").lastName("Hayes").grade(Grade.SENIOR_INFANTS)
                .address(Address.builder()
                        .address1("APT. 1, Tarra House").address2("CityQuarter").city("Athlone").county("Westmeath").build())
                .build());
        students.add(Student.builder()
                .id(1L).firstName("Martin").lastName("Wills").grade(Grade.JUNIOR_INFANTS)
                .address(Address.builder()
                        .address1("APT. 9, Bouleward").address2("CityQuarter").city("Athlone").county("Westmeath").build())
                .build());
        return students;
    }
}
