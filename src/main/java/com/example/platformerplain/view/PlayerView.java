package com.example.platformerplain.view;

import com.example.platformerplain.model.PlayerModel;
import com.example.platformerplain.pattern.Observer;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Objects;

public class PlayerView implements Observer {
    private PlayerModel playerModel;
    private ImageView playerImageView; // 使用ImageView来显示角色图像
    private Pane paneRoot;

    //
//    private final double originalWidth = 500; // the original width
//    private final double originalHeight = 980; // the original height
    private final double scaledWidth = 25; // scaled width
    private final double scaledHeight = 50; // scaled height

    /**
     * Constructor for the player view
     * @param index the index of the character
     */
    public PlayerView(Pane root, PlayerModel playerModel, int index) {
        this.playerModel = playerModel;
        this.playerModel.attach(this);
        paneRoot = root;
        playerImageView = initPlayer(0, 600, index); // initialize the player view at position (0, 600)
    }

    /**
     * when the player model is updated, this method will be called to update the player view
     */
    @Override
    public void update() {
        // update the player view
        drawCharacter((int) playerModel.getX(), (int) playerModel.getY());
    }

    private void drawCharacter(int x, int y) {
        playerImageView.setTranslateX(x); // set the x-coordinate of the image view
        playerImageView.setTranslateY(y); // set the y-coordinate of the image view
    }

    public Node getPlayerNode() {
        return playerImageView;
    }

    /**
     * the method to initialize the player view
     * @param x position of the player on the x-axis
     * @param y position of the player on the y-axis
     * @param index the index of the character
     * @return the initialized player view
     */
    public ImageView initPlayer(int x, int y, int index) {
        // load the character image and set the width and height of the image view
        String url = "/images/character/Character" + index + ".png";
        Image characterImage = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream(url))
        );

        // 计算缩放后的高度来保持纵横比
//        double scaleFactor = scaledWidth / originalWidth;
//        scaledHeight = originalHeight * scaleFactor;

        playerImageView = new ImageView(characterImage);
        playerImageView.setFitWidth(scaledWidth);
        playerImageView.setFitHeight(scaledHeight);
//        playerImageView.setPreserveRatio(true);
        playerImageView.setTranslateX(x);
        playerImageView.setTranslateY(y);
        paneRoot.getChildren().add(playerImageView);
        return playerImageView;
    }

    // mirror inversion of the player view
    public void mirror() {
        if (playerImageView.getScaleX() == -1) {
            playerImageView.setScaleX(1);
            return;
        }
        playerImageView.setScaleX(-1);
    }
}