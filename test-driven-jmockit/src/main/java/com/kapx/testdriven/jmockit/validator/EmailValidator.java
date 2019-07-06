package com.kapx.testdriven.jmockit.validator;

import com.kapx.testdriven.jmockit.employee.EmployeeEntity;
import com.kapx.testdriven.jmockit.employee.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<EmployeeEntity> {
    private Validator validator;

    @Override
    public void setNextValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public void validate(EmployeeEntity entity) {
        if (!isValidEmail(entity.getEmail())) {
            throw new ValidationException("Invalid email. Please check the email format.");
        }

        validator.validate(entity);
    }

    private boolean isValidEmail(final String email) {
        final String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}\\b";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
