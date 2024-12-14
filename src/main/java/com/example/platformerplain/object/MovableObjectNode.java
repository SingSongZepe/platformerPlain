package com.example.platformerplain.object;

import javafx.scene.Node;

public abstract class MovableObjectNode extends MovableNode {
    public static final String FLYING_CARPET_ = "flying_carpet";

    public String movableObjectType;

    public MovableObjectNode(String movableObjectType, Node node) {
        this.node = node;
        this.movableObjectType = movableObjectType;
    }
}
