package com.kapx.testdriven.jmockit.mockstatic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.kapx.testdriven.jmockit.mockstatic.mockstatic.HelloWorld;
import com.kapx.testdriven.jmockit.mockstatic.mockstatic.StringUtil;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class HelloWorldTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Tested
    private HelloWorld helloWorld;

    @Before
    public void setup() {
        // mock static method 'format' from 'StringUtil' class
        new MockUp<StringUtil>() {
            @Mock
            public String format(final String arg) {
                return "! DeKapx !";
            }
        };
    }

    @Test
    public void format_withNull_throwsIllegalArgumentException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument must not be null or empty.");
        helloWorld.sayHello(null);
    }

    @Test
    public void format_withValidInput_returnFormattedOutput() throws Exception {
        final String expected = "! DeKapx !";
        final String actual = helloWorld.sayHello("some value");
        assertThat(actual, is(notNullValue()));
        assertThat(actual, is(equalTo(expected)));
    }
}
