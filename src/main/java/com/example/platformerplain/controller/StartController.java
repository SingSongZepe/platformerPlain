package com.example.platformerplain.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static com.example.platformerplain.Main.getInstance;

public class StartController {
    public Button Start_button_next;
    public ImageView Title_image;
    public ImageView Background_image;
    public Pane Pane_Start;

    /**
     * This method is called when the Start button is clicked. It switches to the home screen.
     * @param actionEvent
     * @throws IOException
     */
    public void switchOnClicked(ActionEvent actionEvent) throws IOException {
        getInstance().setRoot("home");
    }

}
