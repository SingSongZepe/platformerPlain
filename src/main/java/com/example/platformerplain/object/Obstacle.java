package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory class for creating obstacles
 */
public class Obstacle extends Entity {

    /**
     * constructor for obstacle
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image
     */
    public Obstacle(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }
}
