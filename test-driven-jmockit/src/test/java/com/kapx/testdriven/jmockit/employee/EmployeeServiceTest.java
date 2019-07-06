package com.kapx.testdriven.jmockit.employee;

import com.kapx.testdriven.jmockit.validator.EmployeeValidator;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.VerificationsInOrder;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(JMockit.class)
public class EmployeeServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mocked
    private EmployeeRepository mockedRepository;
    @Mocked
    private EmployeeValidator mockedValidator;
    @Mocked
    private EmployeeEntity mockedEntity;

    private EmployeeServiceImpl objUnderTest;

    @Before
    public void setup() {
        objUnderTest = new EmployeeServiceImpl(mockedRepository, mockedValidator);
    }

    @Test
    public void constructorShouldInitializeWithDependencies() throws Exception {
        assertThat(mockedRepository, sameInstance(objUnderTest.getEmployeeRepository()));
        assertThat(mockedValidator, sameInstance(objUnderTest.getEmployeeValidator()));
    }

    @Test
    public void saveWithInvalidEmployeeAttributesThrowValidationException() throws Exception {
        // ARRANGE
        setupEmployeeValidatorMock(false);

        thrown.expect(ValidationException.class);
        thrown.expectMessage("Invalid Employee attributes...");

        // ACT
        objUnderTest.save(mockedEntity);

        // ASSERT
        new Verifications() {{
            mockedValidator.isValidEmployee(withSameInstance(mockedEntity));
        }};
    }

    @Test
    public void saveAlreadyExistingEmployeeThrowDuplicateEntityException() throws Exception {
        // ARRANGE
        setupEmployeeValidatorMock(true);
        setupEmployeeRepositoryMock(mockedEntity);

        thrown.expect(DuplicateEntityException.class);
        thrown.expectMessage("Employee already exists...");

        // ACT
        objUnderTest.save(mockedEntity);

        // ASSERT
        new VerificationsInOrder() {{
            mockedValidator.isValidEmployee(withSameInstance(mockedEntity));
            mockedEntity.getName();
            mockedRepository.findByName(withInstanceOf(String.class));
        }};
    }

    @Test
    public void saveNonExistingEmployeeReturnId() throws Exception {
        // ARRANGE
        setupEmployeeValidatorMock(true);
        setupEmployeeRepositoryMock(null);

        // ACT
        final Long actual = objUnderTest.save(mockedEntity);

        // ASSERT
        assertThat(actual, is(notNullValue()));
        assertThat(actual, is(equalTo(1L)));

        new VerificationsInOrder() {{
            mockedValidator.isValidEmployee(withSameInstance(mockedEntity));
            mockedEntity.getName();
            mockedRepository.findByName(withInstanceOf(String.class));
            mockedRepository.save(withSameInstance(mockedEntity));
        }};
    }

    private void setupEmployeeValidatorMock(final boolean flag) {
        new Expectations() {{
            mockedValidator.isValidEmployee(mockedEntity);
            result = flag;
        }};
    }

    private void setupEmployeeRepositoryMock(final EmployeeEntity entity) {
        new Expectations() {{
            mockedEntity.getName();
            result = "some-name";

            mockedRepository.findByName(anyString);
            result = entity;

            mockedRepository.save(withSameInstance(mockedEntity));
            result = 1L;
        }};
    }
}
