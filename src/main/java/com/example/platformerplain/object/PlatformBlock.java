package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory design pattern for platform block
 */
public class PlatformBlock extends Entity {

    public PlatformBlock(int x, int y, int w, int h, Image image) {
        super(x, y, w, h, image);
    }
}
