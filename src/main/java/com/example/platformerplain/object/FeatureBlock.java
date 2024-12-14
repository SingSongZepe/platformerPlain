package com.example.platformerplain.object;

import javafx.scene.image.Image;

/**
 * factory design pattern
 */
public class FeatureBlock extends Entity {
    public static final String ICE_BLOCK = "ice_block";
    public static final String SNOW_BLOCK = "snow_block";
    public static final String FLYING_CARPET = "flying_carpet";

    public String featureType;

    public FeatureBlock(int x, int y, int w, int h, String featureType, Image image) {
        super(x, y, w, h, image);
        this.featureType = featureType;
    }
}
