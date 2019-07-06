package com.kapx.java.guava.preconditions;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PreConditionsDemoTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    private PreConditionsDemo objectUnderTest;

    @Before
    public void setup() {
        objectUnderTest = new PreConditionsDemo();
    }

    @After
    public void teardown() {
        objectUnderTest = null;
    }

    @Test
    public void sayHello_withNullInput_throwsException() throws Exception {
        exception.expect(NullPointerException.class);
        exception.expectMessage("Argument must not be null.");
        objectUnderTest.sayHello(null);
    }

    @Test
    public void sayHello_withEmptyInput_throwsException() throws Exception {
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Argument must not be empty.");
        objectUnderTest.sayHello("");
    }

    @Test
    public void sayHello_withValidArg_returnValidOutput() throws Exception {
        final String output = objectUnderTest.sayHello("DeKapx");
        assertEquals("-- Hello DeKapx --", output);
    }
}
