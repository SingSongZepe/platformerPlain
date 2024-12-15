package com.example.platformerplain.controller;

import com.example.platformerplain.object.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.example.platformerplain.Main;

import java.io.IOException;

public class OptionController {

    @FXML
    public ImageView Option_closePage;
    @FXML
    public ImageView image_character4;
    @FXML
    public ImageView image_character3;
    @FXML
    public ImageView image_character2;
    @FXML
    public ImageView image_character1;
    @FXML
    public Button character4_button;
    @FXML
    public Button character3_button;
    @FXML
    public Button character2_button;
    @FXML
    public Button character1_button;

    @FXML
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        Main.setRoot("home");
    }

    @FXML
    public void Switch_to_player1(ActionEvent actionEvent) {
        Switch_player(1);
    }

    @FXML
    public void Switch_to_player2(ActionEvent actionEvent) {
        Switch_player(2);
    }

    @FXML
    public void Switch_to_player3(ActionEvent actionEvent) {
        Switch_player(3);
    }

    @FXML
    public void Switch_to_player4(ActionEvent actionEvent) {
        Switch_player(4);
    }

    // recv int index to switch to the corresponding player
    // 1 represents player1, 2 represents player2, 3 represents player3
    // ...
    @FXML
    private void Switch_player(int index) {
        System.out.println("Switch to player " + index);
        Main.gameState.setCharacter(index);
    }

    // when mouse enter -> character image zoom in
    @FXML
    public void MouseEntered_character1(MouseEvent event) {
        image_character1.setFitWidth(220.0);
        image_character1.setFitHeight(350.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        image_character1.setEffect(dropShadow);
    }

    @FXML
    public void MouseEntered_character2(MouseEvent event) {
        image_character2.setFitWidth(220.0);
        image_character2.setFitHeight(350.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        image_character2.setEffect(dropShadow);
    }

    @FXML
    public void MouseEntered_character3(MouseEvent event) {
        image_character3.setFitWidth(220.0);
        image_character3.setFitHeight(350.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        image_character3.setEffect(dropShadow);
    }

    @FXML
    public void MouseEntered_character4(MouseEvent event) {
        image_character4.setFitWidth(220.0);
        image_character4.setFitHeight(350.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        image_character4.setEffect(dropShadow);
    }

    // when mouse exit -> character image zoom out
    @FXML
    public void MouseExited_character1(MouseEvent event) {
        image_character1.setFitWidth(201.0);
        image_character1.setFitHeight(325.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        image_character1.setEffect(dropShadow);
    }

    @FXML
    public void MouseExited_character2(MouseEvent event) {
        image_character2.setFitWidth(174.0);
        image_character2.setFitHeight(325.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        image_character2.setEffect(dropShadow);
    }

    @FXML
    public void MouseExited_character3(MouseEvent event) {
        image_character3.setFitWidth(216.0);
        image_character3.setFitHeight(324.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        image_character3.setEffect(dropShadow);
    }

    @FXML
    public void MouseExited_character4(MouseEvent event) {
        image_character4.setFitWidth(202.0);
        image_character4.setFitHeight(316.0);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(0);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(0);
        image_character4.setEffect(dropShadow);
    }
}
