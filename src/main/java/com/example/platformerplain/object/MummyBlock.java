package com.example.platformerplain.object;

import javafx.scene.image.Image;

public class MummyBlock extends Entity {

    public int[] range;

    /**
     * constructor for MummyBlock with range
     * @param x
     * @param y
     * @param w
     * @param h
     * @param image
     * @param range
     */
    public MummyBlock(int x, int y, int w, int h, Image image, int[] range) {
        super(x, y, w, h, image);
        this.range = range;
    }

    public int[] getRange() {
        return range;
    }
}
