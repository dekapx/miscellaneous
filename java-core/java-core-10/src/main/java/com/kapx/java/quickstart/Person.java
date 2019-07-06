package com.kapx.java.quickstart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
