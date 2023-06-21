package com.example.bubblesortapp;

import java.util.Arrays;

public class BubbleSort {
    // all readonly
    int[] _arr;
    int _position;
    boolean _swapped;
    int _length;
    int _updatedLength;
    SortDirection _sd;

    public BubbleSort(int[] arr)  {
        this(arr, SortDirection.ascending);
    }


    public BubbleSort(int[] arr, SortDirection sortDirection) {
        _arr = arr.clone();
        _position = 0;
        _swapped = false;
        _length = arr.length;
        _updatedLength = arr.length;
        _sd = sortDirection;
    }

    public void NextStep() {
        _swapped = false;

        if (AtEndOfArr()) {
            _position = 0;
            _updatedLength -= 1;
            return;
        }

        int nextPos = _position + 1;

        if (!ValidOrder(_arr[_position], _arr[nextPos])) {
            // swap
            int t = _arr[_position];
            _arr[_position] = _arr[nextPos];
            _arr[nextPos] = t;

            _swapped = true;
        }
        _position = nextPos;
    }


    // accessors
    public boolean IsSorted() {
        for (int i = 0; i < _length - 1; i++) {
            int i2 = i + 1;

            if (!ValidOrder(_arr[i], _arr[i2])) {
                return false;
            }
        }

        return true;
    }

    public int AtIndex(int i) {
        return _arr[i];
    }

    public int Position() {
        return _position;
    }

    public boolean Swapped() {
        return _swapped;
    }

    public int Length() {
        return _length;
    }

    public boolean AtEndOfArr() {
        return _position == _updatedLength - 1;
    }
    public String ArrString() {
        return Arrays.toString(_arr);
    }

    boolean ValidOrder(int first, int second) {
        int d = second - first;

        if (_sd == SortDirection.descending) {
            d = -d;
        }

        return d >= 0;
    }
}
