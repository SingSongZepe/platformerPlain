package com.example.platformerplain.pattern;

import javafx.scene.Node;

public class LineMove extends Movable {

    public int currentX;
    public Boolean movingRight;
    public int[] range;
    public Node node;
    public int velocity;
    public Boolean turnAround;

    public LineMove(int[] range, Node node, int velocity, Boolean turnAround) {
        this.range = range;
        this.node = node;
        this.currentX = 0;
        this.movingRight = true;
        this.velocity = velocity;
        this.turnAround = turnAround;
    }

    @Override
    public void step_move() {
        if (movingRight){
            if (currentX < range[1]) {
                node.setTranslateX(node.getTranslateX() + velocity);
                currentX++;
            } else {
                movingRight = false;
                if (turnAround) node.setScaleX(-1);
            }
        } else {
            if (currentX > range[0]) {
                node.setTranslateX(node.getTranslateX() - velocity);
                currentX--;
            } else {
                movingRight = true;
                if (turnAround) node.setScaleX(1);
            }
        }
    }
}
