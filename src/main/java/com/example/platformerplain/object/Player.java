package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * Factory design pattern for creating player objects
 */
public class Player extends Entity {

    /**
     * constructor for player object
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     */
    public Player(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }
}
