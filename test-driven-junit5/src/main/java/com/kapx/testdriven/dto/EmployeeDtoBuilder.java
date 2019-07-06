package com.kapx.testdriven.dto;

import com.kapx.testdriven.entity.EmployeeEntity;
import com.kapx.testdriven.entity.EmployeeEntityBuilder;

public class EmployeeDtoBuilder {
    private Long id;
    private String firstName;
    private String lastName;
    private String dept;

    private EmployeeDtoBuilder() {
    }

    public static EmployeeDtoBuilder builder() {
        return new EmployeeDtoBuilder();
    }

    public EmployeeDtoBuilder firstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeDtoBuilder lastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeDtoBuilder dept(final String dept) {
        this.dept = dept;
        return this;
    }

    public EmployeeDto build() {
        return new EmployeeDto(firstName, lastName, dept);
    }
}
