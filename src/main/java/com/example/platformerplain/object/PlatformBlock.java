package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory design pattern for platform block
 */
public class PlatformBlock extends Entity {

    /**
     * constructor for platform block
     * @param x
     * @param y
     * @param w
     * @param h
     * @param image
     */
    public PlatformBlock(int x, int y, int w, int h, Image image) {
        super(x, y, w, h, image);
    }
}
