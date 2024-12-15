package com.example.platformerplain.object;

import com.example.platformerplain.pattern.Movable;
import javafx.scene.Node;

public abstract class MovableNode {

    public Node node;
    public Movable movable;

    /**
     * the step move method is called by the game loop to update the position of the node
     */
    public void step_move() {
        movable.step_move();
    }
}
