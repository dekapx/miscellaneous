package com.kapx.testdriven.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String dept;
}
