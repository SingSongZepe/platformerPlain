package com.example.platformerplain.controller;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import multiplewindows.Main;
import com.example.platformerplain.Start;

import java.io.IOException;

public class OptionController {
    public ImageView Option_closePage;

    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        Start.setRoot("home");
    }


}
