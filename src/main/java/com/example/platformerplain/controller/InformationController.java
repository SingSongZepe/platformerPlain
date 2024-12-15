package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static com.example.platformerplain.Start.getInstance;

public class InformationController {
    public ImageView Information_closePage;
    public Button info_level1button;
    public Button info_introbutton;
    public Button info_introduction;
    public Button info_level2button;
    public Pane ContentArea;

    public void Switch_toHome(MouseEvent mouseEvent) throws IOException {
        getInstance().setRoot("home");
    }

    public void switch_intro(ActionEvent actionEvent) {

    }

    public void switch_level1(ActionEvent actionEvent) {

    }

    public void switch_level2(ActionEvent actionEvent) {
    }
}
