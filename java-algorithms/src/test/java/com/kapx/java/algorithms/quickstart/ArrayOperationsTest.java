package com.kapx.java.algorithms.quickstart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTest {
    private ArrayOperations operations = new ArrayOperations();

    @BeforeEach
    void init() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Add new element to array")
    @Test
    public void addNumberToArray() {
        final int[] elements = {3, 5, 2, 4, 1};

        Arrays.stream(elements).forEach(operations::add);

        assertEquals(5, operations.getSize());

        operations.add(6);
        assertEquals(6, operations.getSize());
    }
}
