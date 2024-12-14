package com.example.platformerplain.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * this class used to get ranges of movable objects in the game
 */
public class IntArrayIterator implements Iterator<int[]> {
    private final ArrayList<int[]> data; // create
    private int currentIndex; // current index

    public IntArrayIterator(ArrayList<int[]> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < data.size();
    }

    @Override
    public int[] next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more elements in the iterator.");
        }
        return data.get(currentIndex++);
    }
}