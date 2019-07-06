package com.kapx.testdriven.jmockit.validator;

import com.kapx.testdriven.jmockit.employee.EmployeeEntity;
import com.kapx.testdriven.jmockit.employee.ValidationException;

public class EmployeeValidator implements Validator<EmployeeEntity> {
    private Validator validator;

    public boolean isValidEmployee(final EmployeeEntity entity) {
        boolean flag = true;

        try {
            final Validator nameValidator = new NameValidator();
            this.setNextValidator(nameValidator);
            nameValidator.setNextValidator(new EmailValidator());

            validate(entity);
        } catch (ValidationException exception) {
            flag = false;
        }

        return flag;
    }

    @Override
    public void setNextValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(final EmployeeEntity entity) {
        validator.validate(entity);
    }
}
