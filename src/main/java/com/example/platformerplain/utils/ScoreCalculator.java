package com.example.platformerplain.utils;

import com.example.platformerplain.object.GameState;

public class ScoreCalculator {

    /**
     * Calculates the score based on the time spent and the supplies collected.
     * @param gameState
     * @return
     */
    public static int calculateScore(GameState gameState) {
        return (int) ((GameState.TOTAL_TIME - gameState.spentTime) + 1000 * (gameState.collectedSupplies / 1.0 / gameState.totalSupplies));
    }
}
