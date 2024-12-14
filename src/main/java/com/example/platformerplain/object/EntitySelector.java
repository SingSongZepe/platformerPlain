package com.example.platformerplain.object;

import com.example.platformerplain.utils.EntityCreator;
import javafx.scene.image.ImageView;

import static com.example.platformerplain.Start.*;
import static com.example.platformerplain.utils.InitContentAdapter.getImageView;

/**
 * strategy pattern for selecting entities
 * when maps are different, the contents of the map will be differently loaded too.
 */
public class EntitySelector {
    public static void InsertEntity(char c, int j, int i) {
        switch (gameState.map.index) {
            case 1:
                InsertEntityRuleLevel1(c, j, i);
                break;
            case 2:
                InsertEntityRuleLevel2(c, j, i);
                break;
            default:
                break;
        }
    }

    public static void InsertEntityRuleLevel1(char c, int j, int i) {
        switch (c) {
            case '0':  // space
                break;
            case '1': // platform block
                Entity platform = EntityCreator.createEntity(EntityCreator.GLACIER_PLATFORM_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView platform_image = getImageView(platform);

                platforms.add(platform_image);
                gameRoot.getChildren().add(platform_image);
                break;

            case '2': // obstacle: big ice block
                Entity large_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_LARGE_ICE_BLOCK_, j * 60, (i - 1) * 60, 120, 120, 1);
                ImageView large_ice_block_image = getImageView(large_ice_block);

                platforms.add(large_ice_block_image);
                gameRoot.getChildren().add(large_ice_block_image);
                break;

            case '3': // obstacle: small ice block
                Entity small_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_SMALL_ICE_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView small_ice_block_image = getImageView(small_ice_block);

                platforms.add(small_ice_block_image);
                gameRoot.getChildren().add(small_ice_block_image);
                break;

            case '4': // ice block for increasing speed
                Entity ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_ICE_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView ice_block_image = getImageView(ice_block);

                platforms.add(ice_block_image);
                featureNodes.add(new FeatureNode(FeatureBlock.ICE_BLOCK, ice_block_image));
                gameRoot.getChildren().add(ice_block_image);
                break;

            case '5': // ice block for decreasing speed
                Entity snow_block = EntityCreator.createEntity(EntityCreator.GLACIER_SNOW_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView snow_block_image = getImageView(snow_block);

                platforms.add(snow_block_image);
                featureNodes.add(new FeatureNode(FeatureBlock.SNOW_BLOCK, snow_block_image));
                gameRoot.getChildren().add(snow_block_image);
                break;

            case '6': // supply: bottle water
                Entity bottle_water_block = EntityCreator.createEntity(EntityCreator.BOTTLE_WATER_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView bottle_water_image = getImageView(bottle_water_block);

//                        platforms.add(bottle_water_image);
                supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, bottle_water_image));
                gameRoot.getChildren().add(bottle_water_image);
                break;

            case '7': // supply: can
                Entity can_block = EntityCreator.createEntity(EntityCreator.CAN_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView can_image = getImageView(can_block);

//                        platforms.add(can_image);
                supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, can_image));
                gameRoot.getChildren().add(can_image);
                break;

            case '8': // supply: cookie
                Entity cookie_block = EntityCreator.createEntity(EntityCreator.COOKIE_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView cookie_image = getImageView(cookie_block);

//                        platforms.add(cookie_image);
                supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, cookie_image));
                gameRoot.getChildren().add(cookie_image);
                break;

            case '9': // destination: igloo
                Entity igloo_block = EntityCreator.createEntity(EntityCreator.IGLOO_, j * 60, (i - 1) * 60 + 20, 250, 100, 1);
                ImageView igloo_image = getImageView(igloo_block);

                destinationNode = new DestinationNode(DestinationBlock.IGLOO_, igloo_image);
                gameRoot.getChildren().add(igloo_image);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }

    private static void InsertEntityRuleLevel2(char c, int j, int i) {
        switch (c) {
            case '0':  // space
                break;
            case '1': // platform block

                break;

            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }
}
