package com.kapx.testdriven.jmockit.employee;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public Long save(EmployeeEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EmployeeEntity findByName(String name) {
        throw new UnsupportedOperationException();
    }
}
