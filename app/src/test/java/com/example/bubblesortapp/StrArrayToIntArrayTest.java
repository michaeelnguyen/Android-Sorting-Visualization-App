package com.example.bubblesortapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrArrayToIntArrayTest {
    static final String[] strArrExample1 = new String[]{"1", "2", "3", "4"};
    static final String[] strArrExample2 = new String[]{"1", "2", "33", "44", "55"};

    @Test
    public void stringArrToIntArr() {

        int[] intArr = StrArrayToIntArray.convertToIntArray(strArrExample1);
        assertArrayEquals(new int[]{1,2,3,4}, intArr);

        intArr = StrArrayToIntArray.convertToIntArray(strArrExample2);
        assertArrayEquals(new int[]{1,2,33,44,55}, intArr);
    }
}