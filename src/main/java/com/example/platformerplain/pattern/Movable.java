package com.example.platformerplain.pattern;

public abstract class Movable {
    public static final String LINE_MOVE_ = "line_move";
    public static final String NO_MOVE_ = "no_move";

    /**
     * this method is used to move the object
     */
    public abstract void step_move();
}
