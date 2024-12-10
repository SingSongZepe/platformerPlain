package com.example.platformerplain.controller;

import com.example.platformerplain.SettingApplication;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class SettingController {
    public Button character_button1;
    public Button character_button2;
    public Button character_button3;
    public Button character_button4;
    public ImageView character1;
    public ImageView character4;
    public ImageView character2;
    public ImageView character3;
    public ImageView close_setting;

    @FXML
    public void character_button1_Event(ActionEvent actionEvent) {
    }
    @FXML
    public void character_button2_Event(ActionEvent actionEvent) {
    }
    @FXML
    public void character_button3_Event(ActionEvent actionEvent) {
    }

    public void character_button4_Event(ActionEvent actionEvent) {
    }

    // !TODO
    // 点击按钮后给图片换为加边框的
    public void button1_click(MouseEvent event) {
//        changeCharacterImage(character1, "/Users/apple/Desktop/PlatformerPlain/src/images/1_StartMain/InfoClick.png");
    }

    public void button2_click(MouseEvent event) {
//        changeCharacterImage(character1, "/Users/apple/Desktop/PlatformerPlain/src/images/1_StartMain/InfoClick.png");
    }

    public void button3_click(MouseEvent event) {
//        changeCharacterImage(character1, "/Users/apple/Desktop/PlatformerPlain/src/images/1_StartMain/InfoClick.png");
    }

    public void button4_click(MouseEvent event) {
//        changeCharacterImage(character1, "/Users/apple/Desktop/PlatformerPlain/src/images/1_StartMain/InfoClick.png");
    }
    // 替换人物图片
    /*
    private void changeCharacterImage(ImageView imageView, String imagePath) {
        Image newImage = new Image(getClass().getResourceAsStream(imagePath));
        imageView.setImage(newImage);
    }
     */

    // 点击close后退出setting页面跳转至HomePage
    public void go_HomePage(MouseEvent event) throws IOException {
        SettingApplication.setRoot("HomePage");
    }
}
