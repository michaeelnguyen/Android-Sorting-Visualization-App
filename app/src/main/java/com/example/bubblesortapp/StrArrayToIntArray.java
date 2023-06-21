package com.example.bubblesortapp;

import java.util.Arrays;

public class StrArrayToIntArray {
    public static int[] convertToIntArray(String[] strArr){
        if (strArr == null || strArr.length == 0){ return null; }

        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();

        return intArr;
    }
}
