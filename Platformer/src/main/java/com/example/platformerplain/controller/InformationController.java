package com.example.platformerplain.controller;

import com.example.platformerplain.Main;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InformationController {
    public ImageView Information_closePage;

    public void Switch_toHome(MouseEvent mouseEvent) throws IOException {
        Main.setRoot("home");
    }
}
