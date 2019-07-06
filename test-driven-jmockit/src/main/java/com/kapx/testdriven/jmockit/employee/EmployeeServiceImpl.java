package com.kapx.testdriven.jmockit.employee;

import com.kapx.testdriven.jmockit.validator.EmployeeValidator;

public class EmployeeServiceImpl extends AbstractService<EmployeeEntity> implements EmployeeService {
    private EmployeeRepository repository;
    private EmployeeValidator validator;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public EmployeeRepository getEmployeeRepository() {
        return repository;
    }

    public EmployeeValidator getEmployeeValidator() {
        return validator;
    }

    @Override
    public Long save(final EmployeeEntity entity) {
        validateEntity(entity);
        return repository.save(entity);
    }

    @Override
    protected void validateEntity(final EmployeeEntity entity) {
        if (!validator.isValidEmployee(entity)) {
            throw new ValidationException("Invalid Employee attributes...");
        }

        if (repository.findByName(entity.getName()) != null) {
            throw new DuplicateEntityException("Employee already exists...");
        }
    }
}
