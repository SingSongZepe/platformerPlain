package com.example.platformerplain.object;

import com.example.platformerplain.pattern.LineMove;
import javafx.scene.Node;

public class MummyNode extends EnemyNode {

    /**
     * Constructor for mummy node
     * @param enemyType
     * @param node
     * @param range
     */
    public MummyNode(String enemyType, Node node, int[] range) {
        super(enemyType, node);
        this.movable = new LineMove(range, node, Value.MUMMY_MOVING_VELOCITY, true);
    }
}
