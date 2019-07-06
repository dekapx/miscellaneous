package com.kapx.testdriven.basics;

import org.junit.*;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class HelloWorldTest {
    private HelloWorld objUnderTest = new HelloWorld();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() throws Exception {
    }

    @After
    public void teardown() throws Exception {
    }

    @Test
    public void sayHello_withNullArgument_throwIllegalArgumentException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument must not be null or empty.");
        objUnderTest.sayHello(null);
    }

    @Test
    public void sayHello_withEmptyArgument_throwIllegalArgumentException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument must not be null or empty.");
        objUnderTest.sayHello("");
    }

    @Test
    public void sayHello_withValidArgument_returnValidOutput() throws Exception {
        final String arg = "Java";

        final String actual = objUnderTest.sayHello(arg);

        assertEquals("Hello ! Java", actual);
    }

}
