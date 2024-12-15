package com.example.platformerplain.object;

/**
 * design pattern: Decorator.
 * Decorator design pattern implementation for Character class.
 * add new features to the Character class without changing the original class.
 */
public class Character {

    // four characters here:
    private static final int CHARACTER_1_INDEX = 1;
    private static final String CHARACTER_1_NAME = "Bouncy Amy";

    private static final int CHARACTER_2_INDEX = 2;
    private static final String CHARACTER_2_NAME = "Brave Carl";

    private static final int CHARACTER_3_INDEX = 3;
    private static final String CHARACTER_3_NAME = "Smart Jack";

    private static final int CHARACTER_4_INDEX = 4;
    private static final String CHARACTER_4_NAME = "Explorer Lily";

    public int index;
    public String name;

    /**
     * constructor with default values
     */
    public Character() {
        this.index = CHARACTER_1_INDEX;
        this.name = CHARACTER_1_NAME;
    }

    /**
     * constructor with index and name
     * @param index
     * @param name
     */
    public Character(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * get character name by index
     * @param index
     * @return
     */
    public static String getNameByIndex(int index) {
        return switch (index) {
            case CHARACTER_1_INDEX -> CHARACTER_1_NAME;
            case CHARACTER_2_INDEX -> CHARACTER_2_NAME;
            case CHARACTER_3_INDEX -> CHARACTER_3_NAME;
            case CHARACTER_4_INDEX -> CHARACTER_4_NAME;
            default -> CHARACTER_1_NAME;
        };
    }
}
