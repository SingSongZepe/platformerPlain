package com.example.platformerplain.object;

/**
 * design pattern: Singleton.
 * Singleton class that holds the game state.
 */
public class GameState {
    private GameState() {
        this.character = new Character();
    }

    // lazy initialization of the singleton instance
    private static class Holder {
        public static final GameState gameState = new GameState();
    }

    public static GameState getInstance() {
        return Holder.gameState;
    }

    // game state variables
    private Character character;
    // getters and setters
    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
    }
}
