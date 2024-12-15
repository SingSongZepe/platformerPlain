package com.example.platformerplain.object;

import com.example.platformerplain.utils.EntityCreator;
import javafx.scene.image.ImageView;

import static com.example.platformerplain.Main.*;
import static com.example.platformerplain.utils.InitContentAdapter.getImageView;

/**
 * strategy pattern for selecting entities
 * when maps are different, the contents of the map will be differently loaded too.
 */
public class EntitySelector {
    public static void InsertEntity(char c, int j, int i) {
        switch (getInstance().gameState.map.index) {
            case 1:
                InsertEntityRuleLevel1(c, j, i);
                break;
            case 2:
                InsertEntityRuleLevel2(c, j, i);
                break;
            case 3:
                InsertEntityRuleLevel1(c, j, i);
            default:
                break;
        }
    }

    /**
     * insert entities into game models according to the rules of level 1
     * @param c
     * @param j
     * @param i
     */
    public static void InsertEntityRuleLevel1(char c, int j, int i) {
        switch (c) {
            case '0':  // space
                break;
            case '1': // platform block
                Entity platform = EntityCreator.createEntity(EntityCreator.GLACIER_PLATFORM_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView platform_image = getImageView(platform);

                getInstance().platforms.add(platform_image);
                getInstance().gameRoot.getChildren().add(platform_image);
                break;

            case '2': // obstacle: big ice block
                Entity large_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_LARGE_ICE_BLOCK_, j * 60, (i - 1) * 60, 120, 120, 1);
                ImageView large_ice_block_image = getImageView(large_ice_block);

                getInstance().platforms.add(large_ice_block_image);
                getInstance().gameRoot.getChildren().add(large_ice_block_image);
                break;

            case '3': // obstacle: small ice block
                Entity small_ice_block = EntityCreator.createEntity(EntityCreator.GLACIER_SMALL_ICE_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView small_ice_block_image = getImageView(small_ice_block);

                getInstance().platforms.add(small_ice_block_image);
                getInstance().gameRoot.getChildren().add(small_ice_block_image);
                break;

            case '4': // ice block for increasing speed
                Entity ice_block_block = EntityCreator.createEntity(EntityCreator.GLACIER_ICE_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView ice_block_image = getImageView(ice_block_block);

                getInstance().platforms.add(ice_block_image);
                getInstance().featureNodes.add(new FeatureNode(FeatureBlock.ICE_BLOCK, ice_block_image));
                getInstance().gameRoot.getChildren().add(ice_block_image);
                break;

            case '5': // ice block for decreasing speed
                Entity snow_block_block = EntityCreator.createEntity(EntityCreator.GLACIER_SNOW_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView snow_block_image = getImageView(snow_block_block);

                getInstance().platforms.add(snow_block_image);
                getInstance().featureNodes.add(new FeatureNode(FeatureBlock.SNOW_BLOCK, snow_block_image));
                getInstance().gameRoot.getChildren().add(snow_block_image);
                break;

            case '6': // supply: bottle water
                Entity bottle_water_block = EntityCreator.createEntity(EntityCreator.BOTTLE_WATER_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView bottle_water_image = getImageView(bottle_water_block);

//                        platforms.add(bottle_water_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, bottle_water_image));
                getInstance().gameRoot.getChildren().add(bottle_water_image);
                break;

            case '7': // supply: can
                Entity can_block = EntityCreator.createEntity(EntityCreator.CAN_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView can_image = getImageView(can_block);

//                        platforms.add(can_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, can_image));
                getInstance().gameRoot.getChildren().add(can_image);
                break;

            case '8': // supply: cookie
                Entity cookie_block = EntityCreator.createEntity(EntityCreator.COOKIE_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView cookie_image = getImageView(cookie_block);

//                        platforms.add(cookie_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, cookie_image));
                getInstance().gameRoot.getChildren().add(cookie_image);
                break;

            case '9': // destination: igloo
                Entity igloo_block = EntityCreator.createEntity(EntityCreator.IGLOO_, j * 60, (i - 1) * 60 + 20, 250, 100, 1);
                ImageView igloo_image = getImageView(igloo_block);

                getInstance().destinationNode = new DestinationNode(DestinationBlock.IGLOO_, igloo_image);
                getInstance().gameRoot.getChildren().add(igloo_image);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }

    /**
     * insert entities into game models according to the rules of level 2
     * @param c
     * @param j
     * @param i
     */
    private static void InsertEntityRuleLevel2(char c, int j, int i) {
        switch (c) {
            case '0':  // space
                break;
            case '1': // platform block
                Entity platform = EntityCreator.createEntity(EntityCreator.DESERT_PLATFORM_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView platform_image = getImageView(platform);

                getInstance().platforms.add(platform_image);
                getInstance().gameRoot.getChildren().add(platform_image);
                break;

            case '2': // obstacle: stone
                Entity stone_block = EntityCreator.createEntity(EntityCreator.DESERT_STONE_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView stone_block_image = getImageView(stone_block);

                getInstance().platforms.add(stone_block_image);
                getInstance().gameRoot.getChildren().add(stone_block_image);
                break;

            case '3': // obstacle: cactus
                Entity cactus_block = EntityCreator.createEntity(EntityCreator.DESERT_CACTUS_BLOCK_, j * 60, i * 60, 60, 60, 1);
                ImageView cactus_image = getImageView(cactus_block);

                getInstance().platforms.add(cactus_image);
                getInstance().gameRoot.getChildren().add(cactus_image);
                break;

            case '4': // enemy: fire dragon
                FireDragonBlock fire_dragon_block = (FireDragonBlock) EntityCreator.createEntity(EntityCreator.FIRE_DRAGON_, j * 60, i * 60, 60, 60, 1);
                ImageView fire_dragon_image = getImageView(fire_dragon_block);

                FireDragonNode fire_dragon = new FireDragonNode(EnemyNode.FIRE_DRAGON_, fire_dragon_image, fire_dragon_block.getRange());
                getInstance().enemyNodes.add(fire_dragon);
                getInstance().movableNodes.add(fire_dragon);
                getInstance().gameRoot.getChildren().add(fire_dragon_image);
                break;

            case '5': // enemy: mummy
                MummyBlock mummy_block = (MummyBlock) EntityCreator.createEntity(EntityCreator.MUMMY_, j * 60, i * 60, 60, 60, 1);
                ImageView mummy_image = getImageView(mummy_block);

                MummyNode mummy = new MummyNode(EnemyNode.MUMMY_, mummy_image, mummy_block.getRange());
                getInstance().enemyNodes.add(mummy);
                getInstance().movableNodes.add(mummy);
                getInstance().gameRoot.getChildren().add(mummy_image);
                break;

            case '6': // supply: bottle water
                Entity bottle_water_block = EntityCreator.createEntity(EntityCreator.BOTTLE_WATER_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView bottle_water_image = getImageView(bottle_water_block);

//                        platforms.add(bottle_water_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, bottle_water_image));
                getInstance().gameRoot.getChildren().add(bottle_water_image);
                break;

            case '7': // supply: can
                Entity can_block = EntityCreator.createEntity(EntityCreator.CAN_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView can_image = getImageView(can_block);

//                        platforms.add(can_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, can_image));
                getInstance().gameRoot.getChildren().add(can_image);
                break;

            case '8': // supply: cookie
                Entity cookie_block = EntityCreator.createEntity(EntityCreator.COOKIE_, j * 60 + 20, i * 60 + 40, 20, 20, 1);
                ImageView cookie_image = getImageView(cookie_block);

//                        platforms.add(cookie_image);
                getInstance().supplyNodes.add(new SupplyNode(SupplyBlock.BOTTLE_WATER_, cookie_image));
                getInstance().gameRoot.getChildren().add(cookie_image);
                break;

            case '9': // flying carpet
                FlyingCarpetBlock flying_carpet_block = (FlyingCarpetBlock) EntityCreator.createEntity(EntityCreator.FLYING_CARPET_, j * 60, i * 60, 200, 60, 1);
                ImageView flying_carpet_image = getImageView(flying_carpet_block);

                getInstance().platforms.add(flying_carpet_image);
                getInstance().movableNodes.add(new FlyingCarpetNode(MovableObjectNode.FLYING_CARPET_, flying_carpet_image, flying_carpet_block.getRange()));
                getInstance().gameRoot.getChildren().add(flying_carpet_image);
                break;

            case 'a': // destination: oasis
                Entity oasis_block = EntityCreator.createEntity(EntityCreator.OASIS_, j * 60, (i - 1) * 60 + 30, 250, 100, 1);
                ImageView oasis_image = getImageView(oasis_block);

                getInstance().destinationNode = new DestinationNode(DestinationBlock.OASIS_, oasis_image);
                getInstance().gameRoot.getChildren().add(oasis_image);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }

    /**
     * insert entities for level 3
     * not implemented yet
     * @param c
     * @param j
     * @param i
     */
    private static void InsertEntityRuleLevel3(char c, int j, int i) {
        Entity platform = EntityCreator.createEntity(EntityCreator.DESERT_PLATFORM_BLOCK_, j * 60, i * 60, 60, 60, 1);
        ImageView platform_image = getImageView(platform);

        getInstance().platforms.add(platform_image);
        getInstance().gameRoot.getChildren().add(platform_image);
    }
}
