package com.example.platformerplain.controller;

import com.example.platformerplain.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HomeController {
    @FXML
    public ImageView Home_backgroundImage;
    @FXML
    public Button Home_Option_button;
    @FXML
    public Button Home_Information_button;
    @FXML
    public Button Home_Maps_button;
    @FXML
    public ImageView Home_closePage;
    public Button Home_Start_button;

    @FXML
    public void switchOnClicked_Exit(MouseEvent actionEvent) throws IOException {
        Main.setRoot("start");
    }

    @FXML
    public void switchOnClicked_Maps(ActionEvent actionEvent) throws IOException {
        Main.setRoot("maps");
    }

    @FXML
    public void switchOnClicked_Information(ActionEvent actionEvent) throws IOException {
        Main.setRoot("information");
    }

    @FXML
    public void switchOnClicked_Option(ActionEvent actionEvent) throws IOException {
        Main.setRoot("option");
    }

    /**
     * This method is called when the user clicks on the start button.
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void switchOnClicked_StartGame(ActionEvent actionEvent) throws IOException {
        System.out.println("Start game");

        // clear some data before starting the game
        Main.gameState.spentTime = 0;
        Main.gameState.collectedSupplies = 0;

        Main.startGame();
    }
}
