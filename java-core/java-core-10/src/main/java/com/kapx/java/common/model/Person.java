package com.kapx.java.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}

