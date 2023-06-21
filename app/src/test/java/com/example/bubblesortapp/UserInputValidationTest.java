package com.example.bubblesortapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserInputValidationTest {
    static final String s = "1 2 3";
    static final String s2 = "1 2 3 4 5 6 7 8";
    static final String s3 = "1,2,3,4,5,6,7,8";
    static final String s4 = "1 2 3 4 5 6 7 8 9";
    static final String s5 = "1 2";
    static final String s6 = "a1a1a1";
    static final String s7 = "a 1 a 1 a 1 a";
    static final String s8 = "11 22 33 44";
    static final String s9 = "1, a, 2, b, 33, 44, c";
    static final String s10 = "";
    static final String s11 = "1 2 3    ";

    @Test
    public void checkUserInput() {
        // Valid User Input
        assertTrue(UserInputValidation.CheckUserInput(s));
        assertTrue(UserInputValidation.CheckUserInput(s2));
        assertTrue(UserInputValidation.CheckUserInput(s3));
        // Invalid User Input
        assertFalse(UserInputValidation.CheckUserInput(s4));
        assertFalse(UserInputValidation.CheckUserInput(s5));
        assertFalse(UserInputValidation.CheckUserInput(s6));
        assertFalse(UserInputValidation.CheckUserInput(s7));
        assertFalse(UserInputValidation.CheckUserInput(s8));
        assertFalse(UserInputValidation.CheckUserInput(s9));
        assertFalse(UserInputValidation.CheckUserInput(s10));

        assertTrue(UserInputValidation.CheckUserInput(s11));

    }
}