package com.company;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {

    private Utilities util;

    @Before
    public void setup() {
        // this is run before each test
        util = new Utilities();
    }

    @Test
    public void everyNthChar() {
        //Utilities util = new Utilities();
        // ann array of strings
        // everyNthChar method takes 2 params, char array and an int
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[]{'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @Test
    public void removePairs() {
        // giving it a string with pairs, expecting pairs to be removed
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        // testing for null
        assertNull("Did not get null returned when arg passed was null", util.removePairs(null));
        // testing less than 2 chars
        assertEquals("A", util.removePairs("A"));
        // testing empty string
        assertEquals("", util.removePairs(""));
    }

    @Test
    public void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception {
        // dividing by zero, should get exception, which is why we added it to the Test annotation
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        // this method returns null if length is odd, so testing for that with assertNull
        assertNull(util.nullIfOddLength("odd"));
        // testing not null for an even length word
        assertNotNull(util.nullIfOddLength("even"));
    }
}