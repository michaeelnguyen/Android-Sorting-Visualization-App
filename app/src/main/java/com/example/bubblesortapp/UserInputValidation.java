package com.example.bubblesortapp;

public class UserInputValidation {
    public static boolean CheckUserInput(String message) {
        boolean isValid = false;

        if (message.matches("^\\d([\\s,]+\\d){2,7}?(\\s+)?$")) { isValid = true; }

        return isValid;
    }
}
