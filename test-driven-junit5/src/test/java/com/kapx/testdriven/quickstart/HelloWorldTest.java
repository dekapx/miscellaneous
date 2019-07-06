package com.kapx.testdriven.quickstart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldTest {
    private HelloWorld objUnderTest;

    @BeforeEach
    void init() {
        objUnderTest = new HelloWorld();
    }

    @AfterEach
    void tearDown() {
        objUnderTest = null;
    }

    @Test
    @DisplayName("sayHello with null input")
    void sayHello_withNullInput_throwsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            objUnderTest.sayHello(null);
        });
        assertEquals(exception.getMessage(), "Argument must not be null or empty.");
    }

    @Test
    @DisplayName("sayHello with empty input")
    void sayHello_withEmptyInput_throwsIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            objUnderTest.sayHello("");
        });
        assertEquals(exception.getMessage(), "Argument must not be null or empty.");
    }

    @Test
    @DisplayName("sayHello with valid input")
    void sayHello_withValidInput_returnValidOutput() {
        String actual = objUnderTest.sayHello("DeKapx");
        assertAll("output",
                () -> assertNotNull(actual, "should not be null"),
                () -> assertEquals("Hello ! DeKapx", actual, "shuld be equal")
        );
    }
}
