package com.example.platformerplain.object;

import com.example.platformerplain.pattern.LineMove;
import javafx.scene.Node;

public class FlyingCarpetNode extends MovableObjectNode {

    public FlyingCarpetNode(String movableObjectType, Node node, int[] range) {
        super(movableObjectType, node);
        this.movable = new LineMove(range, node, Value.FLYING_CARPET_MOVING_VELOCITY, false);
    }
}
