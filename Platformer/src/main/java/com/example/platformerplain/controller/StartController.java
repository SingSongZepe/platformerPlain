package com.example.platformerplain.controller;

import com.example.platformerplain.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class StartController {
    public Button Start_button_next;
    public ImageView Title_image;
    public ImageView Background_image;
    public Pane Pane_Start;

    public void switchOnClicked(ActionEvent actionEvent) throws IOException {
        Main.setRoot("home");
    }

}
