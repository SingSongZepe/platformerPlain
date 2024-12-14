package com.example.platformerplain.utils;

import com.example.platformerplain.LevelData;
import com.example.platformerplain.Start;
import com.example.platformerplain.controller.PlayerController;
import com.example.platformerplain.object.*;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

import static com.example.platformerplain.Start.*;


public class InitContentAdapter {

    public void initContent() throws IOException {
        int map_index = gameState.map.index;
        switch (map_index) {
            case 1 -> initContent1();
            case 2 -> initContent2();
            case 3 -> initContent3();
            default -> initContent1();
        };
    }

    private void initContent1() throws IOException {
        // load background picture
        ImageView bg = new ImageView(new Image(Objects.requireNonNull(
                Start.class.getResourceAsStream("/images/background/" + Map.getRandomMapBackground(gameState.map.index) + ".jpg")
        )));
        // Set the ImageView to stretch to 1280x720
        bg.setFitWidth(1280); // Set the width to 1280
        bg.setFitHeight(720); // Set the height to 720
        bg.setPreserveRatio(false); // Disable preserving the aspect ratio to stretch the image
        bg.setOpacity(0.5); // Set the opacity to 0.5

        // load level content
        String[] level = LevelData.Levels.get(gameState.map.index - 1);
        int levelWidth = level[0].length() * 60;  // Declare levelWidth in initContent() method directly

        for (int i = 0; i < level.length; i++){
            String line = level[i];
            for (int j=0; j <line.length();j++){
                switch (line.charAt(j)){
                    case '0':  // space
                        break;
                    case '1': // platform block
                        Entity platform = EntityCreator.createEntity(EntityCreator.GLACIER_PLATFORM_BLOCK_,j*60, i *60, 60, 60, 1);
                        ImageView platform_image = getImageView(platform);

                        platforms.add(platform_image);
                        gameRoot.getChildren().add(platform_image);
                        break;
                        
                    case '2': // obstacle: big ice block
                        Entity large_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_LARGE_ICE_BLOCK_,j*60, (i-1)*60, 120, 120, 1);
                        ImageView large_ice_block_image = getImageView(large_ice_block);

                        platforms.add(large_ice_block_image);
                        gameRoot.getChildren().add(large_ice_block_image);
                        break;
                        
                    case '3': // obstacle: small ice block
                        Entity small_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_SMALL_ICE_BLOCK_,j*60, i*60, 60, 60, 1);
                        ImageView small_ice_block_image = getImageView(small_ice_block);

                        platforms.add(small_ice_block_image);
                        gameRoot.getChildren().add(small_ice_block_image);
                        break;

                    case '4': // ice block for increasing speed
                        Entity ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_ICE_BLOCK_,j*60, i*60, 60, 60, 1);
                        ImageView ice_block_image = getImageView(ice_block);

                        platforms.add(ice_block_image);
                        featureNodes.add(new FeatureNode(FeatureBlock.ICE_BLOCK, ice_block_image));
                        gameRoot.getChildren().add(ice_block_image);
                        break;

                    case '5': // ice block for decreasing speed
                        Entity snow_block = EntityCreator.createEntity(EntityCreator.GLACIER_SNOW_BLOCK_,j*60, i*60, 60, 60, 1);
                        ImageView snow_block_image = getImageView(snow_block);

                        platforms.add(snow_block_image);
                        featureNodes.add(new FeatureNode(FeatureBlock.SNOW_BLOCK, snow_block_image));
                        gameRoot.getChildren().add(snow_block_image);
                        break;

                    case '6': // supply: bottle water
                        Entity bottle_water_block = EntityCreator.createEntity(EntityCreator.BOTTLE_WATER_, j*60+20, i*60+40, 20, 20, 1);
                        ImageView bottle_water_image = getImageView(bottle_water_block);

//                        platforms.add(bottle_water_image);
                        supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, bottle_water_image));
                        gameRoot.getChildren().add(bottle_water_image);
                        break;

                    case '7': // supply: can
                        Entity can_block = EntityCreator.createEntity(EntityCreator.CAN_, j*60+20, i*60+40, 20, 20, 1);
                        ImageView can_image = getImageView(can_block);

//                        platforms.add(can_image);
                        supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, can_image));
                        gameRoot.getChildren().add(can_image);
                        break;

                    case '8': // supply: cookie
                        Entity cookie_block = EntityCreator.createEntity(EntityCreator.COOKIE_, j*60+20, i*60+40, 20, 20, 1);
                        ImageView cookie_image = getImageView(cookie_block);

//                        platforms.add(cookie_image);
                        supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, cookie_image));
                        gameRoot.getChildren().add(cookie_image);
                        break;

                    case '9': // destination: igloo
                        Entity igloo_block = EntityCreator.createEntity(EntityCreator.IGLOO_, j*60, (i-1)*60, 120, 120, 1);
                        ImageView igloo_image = getImageView(igloo_block);

                        destinationNode = new DestinationNode(DestinationBlock.IGLOO_, igloo_image);
                        gameRoot.getChildren().add(igloo_image);
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + line.charAt(j));
                }
            }
        }

        playerController = new PlayerController(scene, gameRoot,
                platforms, featureNodes, supplyNodes, destinationNode,
                levelWidth, gameState.character.index);  // Refactor Player using Observer Pattern

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    playerController.update();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.start();
        appRoot.getChildren().addAll(bg, gameRoot);

        // load uiRoot
        InitGameUi.initGameUi();
        appRoot.getChildren().add(uiRoot);
    }

    private void initContent2() throws IOException {

    }

    private void initContent3() throws IOException {

    }

    private static ImageView getImageView(Entity large_ice_block) {
        ImageView large_ice_block_image = new ImageView();

        large_ice_block_image.setTranslateX(large_ice_block.getX());
        large_ice_block_image.setTranslateY(large_ice_block.getY());
        large_ice_block_image.setImage(large_ice_block.getImage());
        large_ice_block_image.setFitWidth(large_ice_block.getWidth());
        large_ice_block_image.setFitHeight(large_ice_block.getHeight());
        large_ice_block_image.setPreserveRatio(false);

        return large_ice_block_image;
    }
}
