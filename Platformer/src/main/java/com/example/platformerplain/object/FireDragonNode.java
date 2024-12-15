package com.example.platformerplain.object;

import com.example.platformerplain.pattern.LineMove;
import javafx.scene.Node;

public class FireDragonNode extends EnemyNode {
    public FireDragonNode(String enemyType, Node node, int[] range) {
        super(enemyType, node);
        this.movable = new LineMove(range, node, Value.FIRE_DRAGON_MOVING_VELOCITY, true);
    }
}
