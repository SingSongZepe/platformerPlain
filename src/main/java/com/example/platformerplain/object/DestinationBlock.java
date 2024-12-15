package com.example.platformerplain.object;

import javafx.scene.image.Image;

public class DestinationBlock extends Entity {
    public static final String IGLOO_ = "igloo";
    public static final String OASIS_ = "oasis";

    public String destinationType;

    /**
     * constructor for DestinationBlock
     * @param x
     * @param y
     * @param w
     * @param h
     * @param map_index
     * @param image
     */
    public DestinationBlock(int x, int y, int w, int h, int map_index, Image image) {
        super(x, y, w, h, image);
        this.destinationType = switch (map_index) {
            case 1 -> IGLOO_;
            case 2 -> OASIS_;
            case 3 -> IGLOO_;
            default -> throw new IllegalStateException("Unexpected value: " + map_index);
        };
    }
}
