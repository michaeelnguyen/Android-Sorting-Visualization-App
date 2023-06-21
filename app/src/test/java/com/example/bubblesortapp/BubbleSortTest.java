package com.example.bubblesortapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

    static final int[] _arr = new int[]{1,3,5,4,2};
    BubbleSort bs = new BubbleSort(_arr, SortDirection.ascending);

    @Test
    public void validate_nextStep() {
        // Position = 0
        bs.NextStep();
        assertEquals(1, bs._position);
        assertFalse(bs._swapped);

        // Position = 2
        bs._position = 2;
        bs.NextStep();
        assertEquals(3, bs._position);
        assertTrue(bs._swapped);
        assertEquals("[1, 3, 4, 5, 2]", bs.ArrString());
    }

    @Test
    public void validate_isSorted() {
        // Unsorted
        assertFalse(bs.IsSorted());

        // Sorted
        int[] arr = new int[]{1,2,3,4,5};
        BubbleSort bs2 = new BubbleSort(arr, SortDirection.ascending);
        assertTrue(bs2.IsSorted());
    }

    @Test
    public void validate_atIndex() {
        int i = 3;
        assertEquals(4, bs.AtIndex(i));
    }

    @Test
    public void validate_position() {
        assertEquals(0, bs._position);
    }

    @Test
    public void validate_swapped() {
        assertFalse(bs._swapped);
    }

    @Test
    public void validate_length() {
        assertEquals(5, bs._length);
    }

    @Test
    public void validate_atEndOfArr() {
        // Position = 0
        assertFalse(bs.AtEndOfArr());

        // Position = Length of Array
        bs._position = 4;
        assertTrue(bs.AtEndOfArr());
    }

    @Test
    public void validate_arrString() {
        // String Conversion Test
        assertEquals("[1, 3, 5, 4, 2]", bs.ArrString());
    }

    @Test
    public void validate_validOrder() {
        // Valid order
        assertTrue(bs.ValidOrder(_arr[0], _arr[1]));

        // Invalid order
        assertFalse(bs.ValidOrder(_arr[2], _arr[3]));
    }
}