package com.example.platformerplain.object;

import javafx.scene.image.Image;

public abstract class Entity {
    public int x;
    public int y;
    public int w;
    public int h;
    public Image image;

    public Entity(int x, int y, int w, int h, Image image) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
    }

    // getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    public Image getImage() {
        return image;
    }
}
