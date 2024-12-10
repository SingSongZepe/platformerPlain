package com.example.platformerplain.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import multiplewindows.Main;
import com.example.platformerplain.Start;

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
    public Button Home_Setting_button;
    @FXML
    public ImageView Home_closePage;
    public Button Home_Start_button;

    @FXML
    public void switchOnClicked_Exit(MouseEvent actionEvent) throws IOException {
        Start.setRoot("start");
    }

    @FXML
    public void switchOnClicked_Maps(ActionEvent actionEvent) throws IOException {
        Start.setRoot("maps");
    }

    @FXML
    public void switchOnClicked_Information(ActionEvent actionEvent) throws IOException {
        Start.setRoot("information");
    }

    @FXML
    public void switchOnClicked_Option(ActionEvent actionEvent) throws IOException {
        Start.setRoot("option");
    }

    @FXML
    // 直接跳转至第一关游戏开始界面
    // 待添加页面
    public void switchOnClicked_StartGame(ActionEvent actionEvent) {

    }
}
