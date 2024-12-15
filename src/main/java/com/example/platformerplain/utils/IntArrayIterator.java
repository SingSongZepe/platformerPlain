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

    /**
     * constructor for IntArrayIterator
     * @param data
     */
    public IntArrayIterator(ArrayList<int[]> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    /**
     * when there are more elements in the iterator, return true
     * @return
     */
    @Override
    public boolean hasNext() {
        return currentIndex < data.size();
    }

    /**
     * return the next element in the iterator if there is one or more
     * else throw a NoSuchElementException
     * @return
     */
    @Override
    public int[] next() {
        if (!hasNext()) {
            throw new NoSuchElementException("There are no more elements in the iterator.");
        }
        return data.get(currentIndex++);
    }
}