package com.kapx.testdriven.basics;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

//@RunWith(JUnitParamsRunner.class)
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
        // verify items in insertion order
        assertThat(elements, contains("Java", "Scala", "Closure"));
        // verify items in any order
        assertThat(elements, containsInAnyOrder("Closure", "Scala", "Java"));
    }

    @Test
    public void checkIfCollectionIsEmpty() throws Exception {
        final List<String> elements = new ArrayList<>();
        assertThat(elements, empty());
    }

    @Test
    public void checkForCollectionSize() throws Exception {
        final List<String> languages = new ArrayList<>(Arrays.asList("Java", "Scala", "Clojure"));
        assertThat(languages, hasSize(3));
    }

    @Test
    public void checkForElementInCollection() throws Exception {
        final List<String> languages = new ArrayList<>(Arrays.asList("Java", "Scala", "Clojure"));
        assertThat(languages, hasItem("Java"));

        languages.remove("Clojure");
        assertThat(languages, not(hasItem("Clojure")));
    }

    @Test
    public void checkForEmptyArray() throws Exception {
        final String[] array = {};
        assertThat(array, is(emptyArray()));
    }

    @Test
    public void checkForNotEmptyArray() throws Exception {
        final String[] array = {"something"};
        assertThat(array, not(emptyArray()));
    }

    @Test
    public void checkForElementInArray() throws Exception {
        final String[] array = {"Java", "Scala", "Kotlin"};
        assertThat(array, hasItemInArray("Kotlin"));
    }

    @Test
    public void checkForArraySize() throws Exception {
        final String[] array = {"Java", "Scala", "Kotlin"};
        assertThat(array, arrayWithSize(3));
    }

    @Test
    public void checkConditionOnCollectionElements() throws Exception {
        final List<Double> priceList = new ArrayList<>(Arrays.asList(10.25, 25.99, 45.50, 89.99));
        assertThat(priceList, everyItem(greaterThan(10.00)));
        assertThat(priceList, everyItem(lessThan(100.00)));
    }

    @Test
    public void checkElementsInMap() throws Exception {
        final Map<String, String> map = new HashMap();
        map.put("foo", "bar");
        assertThat(map, hasKey("foo"));
        assertThat(map, hasValue("bar"));
        assertThat(map, hasEntry("foo", "bar"));
    }

}
