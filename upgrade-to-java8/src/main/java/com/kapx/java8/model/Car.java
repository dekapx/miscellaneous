package com.kapx.java8.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Car {
    private String name;
    private CarType type;
    private String color;
}
