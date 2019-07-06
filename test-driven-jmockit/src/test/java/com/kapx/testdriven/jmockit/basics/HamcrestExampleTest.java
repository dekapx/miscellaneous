package com.kapx.testdriven.jmockit.basics;

import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(JMockit.class)
public class HamcrestExampleTest {
    private HamcrestExample objUnderTest = new HamcrestExample();

    @Test
    public void sayHello_equalsCheck() {
        final String actual = objUnderTest.sayHello("Java");
        final String expected = "Hello ! Java";
        // using assert statements
        assertEquals(expected, actual);

        // using hamcrest matchers
        assertThat(actual, is(expected));
        assertThat(actual, equalTo(expected));
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void sayHello_notEqualsCheck() {
        final String actual = objUnderTest.sayHello("Scala");
        final String expected = "Hello ! Java";
        // using assert statements
        assertNotEquals(expected, actual);

        // using hamcrest matchers
        assertThat(actual, not(expected));
        assertThat(actual, not(equalTo(expected)));
        assertThat(actual, is(not(equalTo(expected))));
    }

    @Test
    public void sayHello_findAnyOccurrence() {
        final String actual = objUnderTest.sayHello("Java");
        final String expected = "Hello ! Java";
        // using assert statements
        assertTrue(actual.contains("Hello"));
        assertTrue(actual.contains("Java"));

        // using hamcrest matchers
        assertThat(actual, anyOf(containsString("Hello"), containsString("Java")));
    }

    @Test
    public void sum_equalsCheck() {
        final double expected = 7.0;
        final double actual = objUnderTest.sum(1.3, 2.7, 3.0);
        // using assert statements
        // assertEquals(actual, expected);     // deprecated method for comparing doubles...

        // other option using assertEquals
        final double DELTA = 1e-15;
        assertEquals(actual, expected, DELTA);

        // using hamcrest matchers
        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void concat_checkElementsInCollection() {
        final String[] languages = {"Java", "Scala", "Closure"};
        final List<String> elements = objUnderTest.concat(languages);

        // using assert statements
        assertTrue(elements.containsAll(Arrays.asList(languages)));

        // using hamcrest matchers
        assertThat(elements, containsInAnyOrder("Closure", "Scala", "Java"));
    }

}
