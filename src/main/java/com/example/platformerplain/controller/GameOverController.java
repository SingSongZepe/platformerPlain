package com.example.platformerplain.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import com.example.platformerplain.Start;
import javafx.scene.image.ImageView;

import java.io.IOException;

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
        Start.gameState.spentTime = 0;
        Start.gameState.collectedSupplies = 0;

        Start.startGame();
    }

    /**
     * when the game is over, and user clicks on the exit button, this method is called.
     * It sets the root of the game to the main menu.
     * @param event
     */
    @FXML
    private void handleExitButtonAction(ActionEvent event) throws IOException {
        Start.setRoot("home");
    }
}

