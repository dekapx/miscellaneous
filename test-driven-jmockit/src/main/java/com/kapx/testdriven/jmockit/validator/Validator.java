package com.kapx.testdriven.jmockit.validator;

public interface Validator<T> {
    void setNextValidator(Validator validator);

    void validate(T type);
}
