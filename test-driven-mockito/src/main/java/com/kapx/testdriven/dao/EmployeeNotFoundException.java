package com.kapx.testdriven.dao;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(final Long id) {
        super("Employee with ID " + id + " not found.");
    }
}
