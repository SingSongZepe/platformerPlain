package com.example.platformerplain.controller;

import com.example.platformerplain.object.Character;
import javafx.event.ActionEvent;
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

    public void Switch_to_player1(ActionEvent actionEvent) {
        Switch_player(1);
    }

    public void Switch_to_player2(ActionEvent actionEvent) {
        Switch_player(2);
    }

    public void Switch_to_player3(ActionEvent actionEvent) {
        Switch_player(3);
    }

    public void Switch_to_player4(ActionEvent actionEvent) {
        Switch_player(4);
    }

    // recv int index to switch to the corresponding player
    // 1 represents player1, 2 represents player2, 3 represents player3
    // ...
    private void Switch_player(int index) {
        System.out.println("Switch to player " + index);
        Start.gameState.setCharacter(index);
    }
}
