package com.example.platformerplain.utils;

import com.example.platformerplain.LevelData;
import com.example.platformerplain.Start;
import com.example.platformerplain.controller.PlayerController;
import com.example.platformerplain.object.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.example.platformerplain.Start.*;


public class InitContentAdapter {
    public void initContent() throws IOException {
        // load background picture
        ImageView bg = getBg();

        // load data of map
        int idx = getInstance().gameState.map.index - 1;
        // load total supplies
        getInstance().gameState.totalSupplies = LevelData.LevelSupplies.get(idx);

        // load level content
        String[] level = LevelData.Levels.get(idx);
        int levelWidth = level[0].length() * 60;  // Declare levelWidth in initContent() method directly

        // load ranges of moving objects
        getInstance().rangeIterator = new IntArrayIterator((ArrayList<int[]>) LevelData.LevelMovableObjectRanges.get(idx));

        for (int i = 0; i < level.length; i++){
            String line = level[i];
            for (int j=0; j <line.length();j++){
                EntitySelector.InsertEntity(line.charAt(j), j, i);
            }
        }

        getInstance().playerController = new PlayerController(getInstance().scene, getInstance().gameRoot,
//                platforms, featureNodes, supplyNodes, destinationNode, movableNodes, enemyNodes,
                levelWidth, getInstance().gameState.character.index);  // Refactor Player using Observer Pattern

        getInstance().timer.start();
        getInstance().appRoot.getChildren().addAll(bg, getInstance().gameRoot);

        // load uiRoot
        InitGameUi.initGameUi();
        getInstance().appRoot.getChildren().add(getInstance().uiRoot);
    }

    /**
     * use entity to generate an imageview
     * @param entity
     * @return
     */
    public static ImageView getImageView(Entity entity) {
        ImageView large_ice_block_image = new ImageView();

        large_ice_block_image.setTranslateX(entity.getX());
        large_ice_block_image.setTranslateY(entity.getY());
        large_ice_block_image.setImage(entity.getImage());
        large_ice_block_image.setFitWidth(entity.getWidth());
        large_ice_block_image.setFitHeight(entity.getHeight());
        large_ice_block_image.setPreserveRatio(false);

        return large_ice_block_image;
    }

    /**
     * get imageView by map_index
     * param map_index is a member of gamsState.map
     * @return
     */
    private static ImageView getBg() {
        ImageView bg = new ImageView(new Image(Objects.requireNonNull(
                Start.class.getResourceAsStream( Map.getRandomMapBackground(getInstance().gameState.map.index))
        )));

        // Set the ImageView to stretch to 1280x720
        bg.setFitWidth(1280); // Set the width to 1280
        bg.setFitHeight(720); // Set the height to 720
        bg.setPreserveRatio(false); // Disable preserving the aspect ratio to stretch the image
        bg.setOpacity(0.5); // Set the opacity to 0.5
        return bg;
    }
}
