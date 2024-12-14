package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory class for creating obstacles
 */
public class Obstacle extends Entity {
    public Obstacle(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }
}
