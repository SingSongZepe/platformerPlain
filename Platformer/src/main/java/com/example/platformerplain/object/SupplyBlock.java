package com.example.platformerplain.object;

import javafx.scene.image.Image;

public class SupplyBlock extends Entity {
    public static final String BOTTLE_WATER_ = "bottle_water";
    public static final String CAN_ = "can";
    public static final String COOKIE_ = "cookie";

    public String supplyType;

    public SupplyBlock(int x, int y, int w, int h, String supplyType, Image image) {
        super(x, y, w, h, image);
        this.supplyType = supplyType;
    }
}
