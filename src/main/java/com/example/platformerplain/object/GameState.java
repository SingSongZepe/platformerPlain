package com.example.platformerplain.object;

/**
 * design pattern: Factory.
 * This class represents the game state. It contains the character object.
 */
public class GameState {

    // game state variables
    public Character character;
    public Map map;

    // in-game variables
    public int totalSupplies;
    public int collectedSupplies;

    public static final int TOTAL_TIME = 300;
    public int spentTime;

    /**
     * Clears the game state.
     */
    public void clear() {
        this.character = new Character();
        this.map = new Map();
        this.totalSupplies = 0;
        this.collectedSupplies = 0;
        this.spentTime = 0;
    }

    /**
     * resets the spent time and collected supplies.
     */
    public void reset() {
        this.spentTime = 0;
        this.collectedSupplies = 0;
    }

    /**
     * Constructor for the game state.
     */
    public GameState() {
        character = new Character();
        map = new Map();

        totalSupplies = 0;
        collectedSupplies = 0;

        spentTime = 0;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setCharacter(int index) {
        this.character.index = index;
        this.character.name = Character.getNameByIndex(index);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setMap(int index) {
        this.map.index = index;
        this.map.map_name = Map.getNameByIndex(index);
    }
}
