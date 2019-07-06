package com.kapx.testdriven.jmockit.validator;

import com.kapx.testdriven.jmockit.employee.EmployeeEntity;
import com.kapx.testdriven.jmockit.employee.ValidationException;

public class NameValidator implements Validator<EmployeeEntity> {
    private Validator validator;

    @Override
    public void setNextValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(EmployeeEntity entity) {
        if (entity.getName() == null || entity.getName().isEmpty()) {
            throw new ValidationException("Name must not be null or empty.");
        }

        validator.validate(entity);
    }
}
