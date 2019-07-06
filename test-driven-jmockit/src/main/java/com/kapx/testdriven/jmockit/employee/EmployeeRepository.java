package com.kapx.testdriven.jmockit.employee;

public interface EmployeeRepository {
    Long save(EmployeeEntity entity);
    EmployeeEntity findByName(String name);
}
