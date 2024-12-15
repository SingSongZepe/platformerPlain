package com.example.platformerplain.object;

import com.example.platformerplain.utils.RandomNumberGenerator;

/**
 * design pattern: Decorator.
 * Decorator design pattern implementation for Character class.
 * add new features to the Character class without changing the original class.
 */
public class Map {

    // four characters here:
    private static final int MAP_1_INDEX = 1;
    private static final String MAP_1_NAME = "glacier";

    private static final int MAP_2_INDEX = 2;
    private static final String MAP_2_NAME = "desert";

    private static final int MAP_3_INDEX = 3;
    private static final String MAP_3_NAME = "forest";

    public int index;
    public String map_name;

    /**
     * constructor with default values
     */
    public Map() {
        this.index = MAP_1_INDEX;
        this.map_name = MAP_1_NAME;
    }

    /**
     * constructor with custom values
     * @param index
     */
    public Map(int index) {
        this.index = index;
        this.map_name = getNameByIndex(index);
    }

    /**
     * constructor with random values
     * @param index
     * @return
     */
    public static String getNameByIndex(int index) {
        return switch (index) {
            case MAP_1_INDEX -> MAP_1_NAME;
            case MAP_2_INDEX -> MAP_2_NAME;
            case MAP_3_INDEX -> MAP_3_NAME;
            default -> MAP_1_NAME;
        };
    }

    /**
     * get random map background url
     * @param index  the url of the map background
     * @return
     */
    public static String getRandomMapBackground(int index) {
        return switch (index) {
            // if there are more pictures for each map, add them here.
            // their names should be the same as the map name + a number.
            // and extension should be .jpg
            case MAP_1_INDEX -> "/images/background/" + MAP_1_NAME + RandomNumberGenerator.getRandomInt(1, 1) + ".jpg";
            case MAP_2_INDEX -> "/images/background/" + MAP_2_NAME + RandomNumberGenerator.getRandomInt(1, 1) + ".jpg";
            case MAP_3_INDEX -> "/images/background/" + MAP_3_NAME + RandomNumberGenerator.getRandomInt(1, 1) + ".jpg";
            default -> "/images/background/" + MAP_1_NAME + RandomNumberGenerator.getRandomInt(1, 1) + ".jpg";
        };
    }
}
