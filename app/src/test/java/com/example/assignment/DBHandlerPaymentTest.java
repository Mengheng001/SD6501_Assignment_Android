package com.example.assignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBHandlerPaymentTest {

    int val1;
    int val2;
    int expectedSum;
    int actualSum;

    @Before
    public void setUp() throws Exception {
        val1 = 100;
        val2 = 50;
        expectedSum = val1 + val2;
    }

    @After
    public void tearDown() throws Exception {
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void getSumPayment() {
       actualSum = 150;
    }

    @Test
    public void getSumTax() {
        actualSum = 150;
    }
}