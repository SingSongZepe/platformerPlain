package com.example.platformerplain.model;

import com.example.platformerplain.pattern.ObservedSubject;
import com.example.platformerplain.pattern.Observer;
import javafx.geometry.Point2D;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class PlayerModel implements ObservedSubject {
    private double x;
    private double y;
    private boolean canJump = true;
    private Point2D playerVelocity = new Point2D(0, 0);
    private ArrayList<Node> platforms = new ArrayList<>();
    private final List<Observer> observers;
    public PlayerModel(){
        observers = new ArrayList<>();
    }
    /**
     * add observer to list of observer
     * @param observer observer which added
     */
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * remove observer to list of observer
     *
     * @param observer observer which removed
     */
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notify observers when the value has been modified
     */
    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.update();
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public Point2D getPlayerVelocity() {
        return playerVelocity;
    }

    public void setPlayerVelocity(Point2D playerVelocity) {
        this.playerVelocity = playerVelocity;
    }

    public ArrayList<Node> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(ArrayList<Node> platforms) {
        this.platforms = platforms;
    }
}
