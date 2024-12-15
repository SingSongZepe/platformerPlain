package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.example.platformerplain.Start.getInstance;

public class InformationController {
    public ImageView Information_closePage;

    public void Switch_toHome(MouseEvent mouseEvent) throws IOException {
        getInstance().setRoot("home");
    }
}
