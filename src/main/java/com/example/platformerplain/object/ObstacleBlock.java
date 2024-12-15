package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory design pattern
 */
public class ObstacleBlock extends Entity {

    /**
     * constructor for obstacle block
     * @param x
     * @param y
     * @param w
     * @param h
     * @param image
     */
    public ObstacleBlock(int x, int y, int w, int h, Image image) {
        super(x, y, w, h, image);
    }
}
