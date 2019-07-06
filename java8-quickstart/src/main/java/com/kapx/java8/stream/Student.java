package com.kapx.java8.stream;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private Grade grade;
    private Address address;
}
