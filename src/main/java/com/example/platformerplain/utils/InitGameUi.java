package com.example.platformerplain.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;

import static com.example.platformerplain.Main.*;
import static com.example.platformerplain.utils.Counter.startCountdown;

public class InitGameUi {
    /**
     * modifies the uiRoot to display the game ui elements
     * so do not receive any input
     * and do not return any output
     */
    public static void initGameUi() {
        VBox uiContainer = new VBox();
        uiContainer.setSpacing(10);
        uiContainer.setAlignment(Pos.CENTER); // Center the content vertically
        uiContainer.setLayoutX(10); // Positioning
        uiContainer.setLayoutY(10);
        uiContainer.setPrefWidth(1280);
        uiContainer.setPrefHeight(80);

        // Create a label to display the timer
        getInstance().timerLabel.setText("Time left: 5:00");
        getInstance().timerLabel.setTextFill(Color.BLACK); // Set text color for visibility
        getInstance().timerLabel.setStyle("-fx-font-size: 24px;");

        // Create an exit button
        Button exitButton = new Button("Exit Game");
        exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Set button color
        exitButton.setCursor(javafx.scene.Cursor.HAND); // Set cursor to hand

        // callback
        exitButton.setOnAction(event -> {
            System.out.println("quit game");
            try {
                getInstance().quitGame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Add hover effects for the button
        exitButton.setOnMouseEntered(event -> {
            exitButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white; -fx-font-size: 16px;"); // Change color on hover
        });

        exitButton.setOnMouseExited(event -> {
            exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Revert color
        });

        // Create a HBox to hold the timer label and exit button
        HBox hbox = new HBox();
        hbox.setSpacing(20); // Set spacing between elements
        hbox.setAlignment(Pos.CENTER); // Center the HBox content
        hbox.getChildren().addAll(getInstance().timerLabel, exitButton); // Add the timer label and button to the HBox

        // Add the HBox to the UI container
        uiContainer.getChildren().add(hbox); // Add the HBox to the uiContainer

        // Add the UI container to the uiRoot
        getInstance().uiRoot.getChildren().add(uiContainer); // Add the uiContainer to the uiRoot

        // Start the countdown timer
        startCountdown(getInstance().timerLabel);
    }
}
