package com.example.platformerplain.object;

import javafx.scene.image.Image;

public class FlyingCarpetBlock extends Entity {

    public int[] range;

    public FlyingCarpetBlock(int x, int y, int w, int h, Image image, int[] range) {
        super(x, y, w, h, image);
        this.range = range;
    }

    public int[] getRange() {
        return range;
    }
}
