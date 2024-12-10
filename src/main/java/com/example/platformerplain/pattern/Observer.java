package com.example.platformerplain.pattern;

/**
 * Observer Pattern
 * Used for communication between View and Model.
 * When the state of the model changes, all views
 * need to be notified to update.
 */
public interface Observer {
    /**
     * When the state of the model changes, all views need to be notified to update.
     */
    void update();
}
