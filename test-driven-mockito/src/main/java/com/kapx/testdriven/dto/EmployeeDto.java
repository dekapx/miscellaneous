package com.kapx.testdriven.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String dept;
}
