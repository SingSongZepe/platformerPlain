package com.example.platformerplain.object;

import com.example.platformerplain.pattern.Movable;
import javafx.scene.Node;

public abstract class MovableNode {

    public Node node;
    public Movable movable;

    public void step_move() {
        movable.step_move();
    }
}
