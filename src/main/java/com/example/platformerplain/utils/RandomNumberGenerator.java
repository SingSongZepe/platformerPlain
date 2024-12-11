package com.example.platformerplain.utils;

import java.util.Random;

/*
 * This class generates a random integer between min and max (inclusive)
 */
public class RandomNumberGenerator {
    /**
     * Generates a random integer between min and max (inclusive)
     * @param min
     * @param max
     * @return a random integer between min and max (inclusive, [min, max])
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        // generate random number between min and max (inclusive)
        return random.nextInt(max - min + 1) + min;
    }
}