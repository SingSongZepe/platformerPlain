package com.example.platformerplain.controller;

import com.example.platformerplain.object.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.platformerplain.Start;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Objects;

public class GameOverController {

    @FXML
    public Label gameOverLabel;

    @FXML
    public ImageView backgroundImage;

    @FXML
    private Button restartButton;

    @FXML
    private Button exitButton;


    @FXML
    public void initialize() {
        backgroundImage.setImage(new Image(Objects.requireNonNull(
                Start.class.getResourceAsStream(Map.getRandomMapBackground(Start.getInstance().gameState.map.index))
        )));

        backgroundImage.setFitWidth(1280); // Set the width to 1280
        backgroundImage.setFitHeight(720); // Set the height to 720
        backgroundImage.setPreserveRatio(false); // Disable preserving the aspect ratio to stretch the image
        backgroundImage.setOpacity(0.5); // Set the opacity to 0.5
    }

    /**
     * when the game is over, and user clicks on the restart button, this method is called.
     * It sets the root of the game to the start screen, and passes the player's score as a parameter.
     * @param event
     */
    @FXML
    private void handleRestartButtonAction(ActionEvent event) throws IOException {
        System.out.println("Restart game");

        // clear some data before starting the game
        Start.getInstance().gameState.spentTime = 0;
        Start.getInstance().gameState.collectedSupplies = 0;

        Start.getInstance().startGame();
    }

    /**
     * when the game is over, and user clicks on the exit button, this method is called.
     * It sets the root of the game to the main menu.
     * @param event
     */
    @FXML
    private void handleExitButtonAction(ActionEvent event) throws IOException {
        Start.getInstance().setRoot("home");
    }
}

