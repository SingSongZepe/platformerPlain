package com.example.platformerplain.utils;

import com.example.platformerplain.object.GameState;

public class ScoreCalculator {
    public static int calculateScore(GameState gameState) {
        return GameState.TOTAL_TIME - gameState.spentTime + 1000 * (gameState.collectedSupplies - gameState.totalSupplies);
    }
}
