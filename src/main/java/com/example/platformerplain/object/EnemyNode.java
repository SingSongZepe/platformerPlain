package com.example.platformerplain.object;

import javafx.scene.Node;

public class EnemyNode extends MovableNode {
    public static final String FIRE_DRAGON_ = "fire_dragon";
    public static final String MUMMY_ = "mummy";

    public String enemyType;

    /**
     * constructor for EnemyNode
     * @param enemyType
     * @param node
     */
    public EnemyNode(String enemyType, Node node) {
        this.node = node;
        this.enemyType = enemyType;
    }
}
