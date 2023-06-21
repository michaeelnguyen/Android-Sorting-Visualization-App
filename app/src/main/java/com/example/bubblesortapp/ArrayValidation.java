package com.example.bubblesortapp;

public class ArrayValidation {
    public static boolean Check(int[] arr) {

        return CheckLength(arr) && CheckRange(arr);
    }

    static boolean CheckLength(int[] arr) {
        return arr.length >= 3 && arr.length <= 8;
    }

    static boolean CheckRange(int[] arr) {
        for (int i : arr) {
            if (i < 0 || i > 9) {
                return false;
            }
        }

        return true;
    }
}
