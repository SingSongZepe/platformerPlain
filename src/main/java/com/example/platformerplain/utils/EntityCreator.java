package com.example.platformerplain.utils;

import com.example.platformerplain.Start;
import com.example.platformerplain.object.*;
import javafx.scene.image.Image;

import java.util.Objects;

public class EntityCreator {
    // character
    public static final String PLAYER_ = "player";

    // supply blocks
    public static final String BOTTLE_WATER_ = "bottle_water";
    public static final String CAN_ = "can";
    public static final String COOKIE_ = "cookie";

    // platform blocks
    public static final String GLACIER_PLATFORM_BLOCK_ = "glacier_platform_block";
    public static final String DESERT_PLATFORM_BLOCK_ = "desert_platform_block";
    public static final String FOREST_PLATFORM_BLOCK_ = "forest_platform_block";

    // obstacle blocks
    public static final String GLACIER_SMALL_ICE_BLOCK_ = "glacier_small_ice_block";
    public static final String GLACIER_LARGE_ICE_BLOCK_ = "glacier_large_ice_block";
    public static final String DESERT_STONE_BLOCK_ = "desert_stone_block";
    public static final String DESERT_CACTUS_BLOCK_ = "desert_cactus_block";

    // feature blocks
    public static final String GLACIER_ICE_BLOCK_ = "glacier_ice_block";
    public static final String GLACIER_SNOW_BLOCK_ = "glacier_snow_block";

    // enemy blocks
    public static final String FIRE_DRAGON_ = "fire_dragon";
    public static final String MUMMY_ = "mummy";

    // destination
    public static final String IGLOO_ = "igloo";
    public static final String OASIS_ = "oasis";

    // movable object blocks
    public static final String FLYING_CARPET_ = "flying_carpet";

//    /**
//     * default constructor to create an entity object
//     * tag means the same entity but different variations
//     * for example, different character, there are 4 variations of character
//     * @param entityType string representing the type of entity to create
//     * @param x          position of the entity on the x-axis
//     * @param y          position of the entity on the y-axis
//     * @param w          width of the entity
//     * @param h          height of the entity
//     * param tag         default tag is 1
//     * @return
//     */
//    public static Entity createEntity(String entityType, int x, int y, int w, int h) {
//        return switch (entityType) {
//            case PLAYER_ -> new Player(x, y, w, h, loadImageView(entityType, 1));
//            case BOTTLE_WATER_ -> new Player(x, y, w, h, loadImageView(entityType, 1));
//            // platform blocks
//            case GLACIER_PLATFORM_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, 1));
//            case DESERT_PLATFORM_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, 4));
//            case FOREST_PLATFORM_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, 9999));
//            // obstacle blocks
//            case GLACIER_SMALL_ICE_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, 1));
//            case GLACIER_LARGE_ICE_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, 1));
//            default -> throw new IllegalStateException("Unexpected value: " + entityType);
//        };
//    }

    /**
     * constructor to create an entity object with a tag
     * @param entityType
     * @param x
     * @param y
     * @param w
     * @param h
     * @param tag
     * @return
     */
    public static Entity createEntity(String entityType, int x, int y, int w, int h, int tag) {
        return switch (entityType) {
            case PLAYER_ -> new Player(x, y, w, h, loadImageView(entityType, tag));
            // supply blocks
            case BOTTLE_WATER_ -> new SupplyBlock(x, y, w, h, SupplyBlock.BOTTLE_WATER_, loadImageView(entityType, tag));
            case CAN_ -> new SupplyBlock(x, y, w, h, SupplyBlock.CAN_, loadImageView(entityType, tag));
            case COOKIE_ -> new SupplyBlock(x, y, w, h, SupplyBlock.COOKIE_, loadImageView(entityType, tag));
            // platform blocks
            case GLACIER_PLATFORM_BLOCK_, DESERT_PLATFORM_BLOCK_, FOREST_PLATFORM_BLOCK_ -> new PlatformBlock(x, y, w, h, loadImageView(entityType, tag));
            // obstacle blocks
            case GLACIER_SMALL_ICE_BLOCK_, GLACIER_LARGE_ICE_BLOCK_, DESERT_STONE_BLOCK_, DESERT_CACTUS_BLOCK_ -> new ObstacleBlock(x, y, w, h, loadImageView(entityType, tag));
            // feature blocks
            case GLACIER_ICE_BLOCK_ -> new FeatureBlock(x, y, w, h, FeatureBlock.ICE_BLOCK, loadImageView(entityType, tag));
            case GLACIER_SNOW_BLOCK_ -> new FeatureBlock(x, y, w, h, FeatureBlock.SNOW_BLOCK, loadImageView(entityType, tag));
            // destination
            case IGLOO_, OASIS_ -> new DestinationBlock(x, y, w, h, Start.gameState.map.index, loadImageView(entityType, tag));
            // enemy blocks
            case FIRE_DRAGON_ -> new FireDragonBlock(x, y, w, h, loadImageView(entityType, tag), Start.rangeIterator.next());
            case MUMMY_ -> new MummyBlock(x, y, w, h, loadImageView(entityType, tag), Start.rangeIterator.next());
            // moving object blocks
            case FLYING_CARPET_ -> new FlyingCarpetBlock(x, y, w, h, loadImageView(entityType, tag), Start.rangeIterator.next());

            default -> throw new IllegalStateException("Unexpected value: " + entityType);
        };
    }

    /**
     * load the image view of the entity
     * tag means the same entity but different variations
     * @param entityType
     * @param tag
     * @return
     */
    public static Image loadImageView(String entityType, int tag) {
        switch (entityType) {
            // player
            case PLAYER_ -> {
                String url = "/images/character/Character" + tag + ".png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }

            // supply
            case BOTTLE_WATER_ -> {
                String url = "/images/supply/water.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case CAN_ -> {
                String url = "/images/supply/can.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case COOKIE_ -> {
                String url = "/images/supply/cookie.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            // platform blocks
            case GLACIER_PLATFORM_BLOCK_ -> {
                String url = "/images/platform/glacier_platform_block3.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case DESERT_PLATFORM_BLOCK_ -> {
                // ! TODO change the image to the correct one
                String url = "/images/platform/desert_platform_block2.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case FOREST_PLATFORM_BLOCK_ -> {
                // ! TODO change the image to the correct one
                String url = "/images/platform/glacier_platform_block3.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            // obstacle blocks
            // they are the same image but with different size
            case GLACIER_SMALL_ICE_BLOCK_, GLACIER_LARGE_ICE_BLOCK_ -> {
                String url = "/images/obstacle/glacier_ice_block.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case DESERT_STONE_BLOCK_ -> {
                String url = "/images/obstacle/desert_stone.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case DESERT_CACTUS_BLOCK_ -> {
                String url = "/images/obstacle/desert_cactus.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            // feature blocks
            case GLACIER_ICE_BLOCK_ -> {
                String url = "/images/feature/glacier_ice_block.jpg";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case GLACIER_SNOW_BLOCK_ -> {
                String url = "/images/feature/glacier_snow_block.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case IGLOO_ -> {
                String url = "/images/destination/glacier_igloo2.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case OASIS_ -> {
                // ! TODO change the image to the correct one
                String url = "/images/destination/desert_oasis.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            // enemy blocks
            case FIRE_DRAGON_ -> {
                String url = "/images/enemy/desert_firedragon.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            case MUMMY_ -> {
                String url = "/images/enemy/desert_mummy.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }
            // moving object blocks
            case FLYING_CARPET_ -> {
                String url = "/images/moving_objects/desert_flying_carpet.png";

                return new Image(Objects.requireNonNull(
                        Start.class.getResourceAsStream(url)
                ));
            }

            default -> {
                throw new IllegalStateException("Unexpected value: " + entityType);
            }
        }
    }
}
