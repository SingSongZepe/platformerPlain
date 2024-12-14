package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import com.example.platformerplain.model.PlayerModel;
import com.example.platformerplain.object.*;
import com.example.platformerplain.view.PlayerView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerController {
    private PlayerModel playerModel;
    private PlayerView playerView;
    private List<Node> platforms;
    private List<FeatureNode> featureNodes;
    private List<SupplyNode> supplyNodes;
    private DestinationNode destinationNode;
    private HashMap<KeyCode, Boolean> keys = new HashMap<>();
    private int levelWidth;
    private int index; // index of character that player selected
    private Pane root;

    // for mirror
    private boolean isMovingRight = true;

    public PlayerController(Scene scene, Pane root,
                            ArrayList<Node> platforms,
                            ArrayList<FeatureNode> featureNodes,
                            ArrayList<SupplyNode> supplyNodes,
                            DestinationNode destinationNode,
                            int levelWidth, int index) {

        playerModel = new PlayerModel();
        playerView = new PlayerView(root, playerModel, index);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
        this.platforms = platforms;
        this.featureNodes = featureNodes;
        this.supplyNodes = supplyNodes;
        this.destinationNode = destinationNode;
        this.levelWidth = levelWidth;
        this.index = index;
        this.root = root;
    }

    public void update() throws IOException {
        if (isPressed(KeyCode.W) && playerModel.getY() >= 5) {
            jumpPlayer();
        }
        if (isPressed(KeyCode.A) && playerModel.getX() >= 5) {
            movePlayerX(-5);
        }
        if (isPressed(KeyCode.D) && playerModel.getX() + playerView.getPlayerNode().getBoundsInLocal().getWidth() <= levelWidth - 5) {
            movePlayerX(5);
        }

        movePlayerY((int) playerModel.getPlayerVelocity().getY()); // move player by velocity
        if (playerModel.getPlayerVelocity().getY() < 10) {
            playerModel.setPlayerVelocity(playerModel.getPlayerVelocity().add(0, 1)); // gravity
        }
        playerModel.notifyObservers(); // update view

        // if playerY is smaller than 780, means player is out of screen (drop into the dark hole)
        // actually, it should be 720, but we add 60 to make sure that the player has opportunity to jump out of the dark hole
        // then game over
        if (playerModel.getY() > 780) {
            try {
                Start.gameOver();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // judge if player intersects with any supply
        SupplyNode toBeDeleted = null;

        for (SupplyNode supplyNode: supplyNodes) {
            if (supplyNode.node.getBoundsInParent().intersects(playerView.getPlayerNode().getBoundsInParent())) {
                System.out.println("get!");
                // when you get the supply, delete it from the array
                toBeDeleted = supplyNode;

                Start.gameState.collectedSupplies += 1;
                break;
            }
        }

        if (toBeDeleted != null) {
            Start.gameRoot.getChildren().remove(toBeDeleted.node);
            supplyNodes.remove(toBeDeleted);
        }

        // check whether the player is at the place of destination
        double playerMinX = playerView.getPlayerNode().getTranslateX();
        double playerMaxX = playerMinX + playerView.getPlayerNode().getBoundsInLocal().getWidth();
        double midPlayerX = (playerMinX + playerMaxX) / 2;

        if (destinationNode.node.getBoundsInParent().contains(midPlayerX, playerModel.getY() + 70)) {
            // you win the game
            Start.gameWin();
        }
    }

    private boolean isPressed(KeyCode keyCode) {
        return keys.getOrDefault(keyCode, false);
    }

    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        if (isMovingRight != movingRight) {
            playerView.mirror();
        }
        isMovingRight = movingRight;

        // calculate the middle point of player
        double playerMinX = playerView.getPlayerNode().getTranslateX();
        double playerMaxX = playerMinX + playerView.getPlayerNode().getBoundsInLocal().getWidth();
        double midPlayerX = (playerMinX + playerMaxX) / 2;

        double speed_factor = 1;

        // judge if the player is on the feature blocks
        for (FeatureNode featureNode : featureNodes) {
            if (featureNode.node.getBoundsInParent().contains(midPlayerX, playerModel.getY() + 70)) {
                speed_factor = switch (featureNode.featureType) {
                    case FeatureBlock.ICE_BLOCK -> 2;
                    case FeatureBlock.SNOW_BLOCK -> 0.5;
                    default -> speed_factor;
                };
                break;
            }
        }

        // when the player is in the center range, move platforms instead of player
        boolean isInCenterRange = midPlayerX < 645 && midPlayerX > 635;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                // get platform boundaries
                double platformMinX = platform.getBoundsInParent().getMinX();
                double platformMaxX = platform.getBoundsInParent().getMaxX();

                // check the collision
                if (playerView.getPlayerNode().getBoundsInParent().intersects(platform.getBoundsInParent())
                        && (playerView.getPlayerNode().getTranslateY() + 50 != platform.getTranslateY())) {
                    // when colliding with platforms, check if the player is in the center range, if yes, move platforms, otherwise, update player position
                    if (movingRight) {
                        if (playerMaxX >= platformMinX && playerMinX < platformMinX) {
                            return;
                        }
                    } else {
                        if (playerMinX <= platformMaxX && playerMaxX > platformMaxX) {
                            return;
                        }
                    }
                }
            }

            // if the player is in the center range, move platforms instead of player
            //  && platformMinX <= 5 && platformMaxX >= 1275
            double displacement = speed_factor * (movingRight ? -1 : 1);
            if (isInCenterRange) {
                // move platforms
                for (Node platform : platforms) {
                    platform.setTranslateX(platform.getTranslateX() + displacement);
                }
                for (SupplyNode supplyNode: supplyNodes) {
                    supplyNode.node.setTranslateX(supplyNode.node.getTranslateX() + displacement);
                }
                destinationNode.node.setTranslateX(destinationNode.node.getTranslateX() + displacement);
            } else {
                // otherwise, update player position
                playerModel.setX((int) (playerModel.getX() - displacement));
                playerView.getPlayerNode().setTranslateX(playerModel.getX());
            }
        }
    }

    private void movePlayerY(int value) {
        boolean movingDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                // get platform boundaries
                double platformMinY = platform.getBoundsInParent().getMinY();
                double platformMaxY = platform.getBoundsInParent().getMaxY();
                double playerMinY = playerView.getPlayerNode().getTranslateY();
                double playerMaxY = playerMinY + playerView.getPlayerNode().getBoundsInLocal().getHeight(); // use actual height

                if (playerView.getPlayerNode().getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (playerMaxY >= platformMinY && playerMinY < platformMinY) {
                            playerModel.setY((int) (platformMinY - playerView.getPlayerNode().getBoundsInLocal().getHeight()));
                            playerModel.setCanJump(true); // can jump again
                            return; // update player position and return
                        }
                    } else {
                        if (playerMinY <= platformMaxY && playerMaxY > platformMaxY) {
                            playerModel.setY((int) platformMaxY);
                            return; // update player position and return
                        }
                    }
                }
            }

            // update position
            playerModel.setY(playerModel.getY() + (movingDown ? 1 : -1));
            playerView.getPlayerNode().setTranslateY(playerModel.getY());
        }
    }

    private void jumpPlayer() {
        if (playerModel.isCanJump()) {
            playerModel.setPlayerVelocity(playerModel.getPlayerVelocity().add(0, -30));
            playerModel.setCanJump(false);
        }
    }

    public void initPlayer(int x, int y) {
        playerModel.setX(x);
        playerModel.setY(y);
    }
}