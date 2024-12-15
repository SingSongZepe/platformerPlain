package com.example.platformerplain.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import multiplewindows.Main;

import java.io.IOException;

import static com.example.platformerplain.Main.getInstance;

public class OptionController {
    public ImageView Option_closePage;

    /**
     * This method is called when the user clicks on the close button on the option page.
     * and back to home page.
     * @param actionEvent
     * @throws IOException
     */
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        getInstance().setRoot("home");
    }

    /**
     * select the first player to play the game.
     * @param actionEvent
     */
    public void Switch_to_player1(ActionEvent actionEvent) {
        Switch_player(1);
    }

    /**
     * select the second player to play the game.
     * @param actionEvent
     */
    public void Switch_to_player2(ActionEvent actionEvent) {
        Switch_player(2);
    }

    /**
     * select the third player to play the game.
     * @param actionEvent
     */
    public void Switch_to_player3(ActionEvent actionEvent) {
        Switch_player(3);
    }

    /**
     * select the fourth player to play the game.
     * @param actionEvent
     */
    public void Switch_to_player4(ActionEvent actionEvent) {
        Switch_player(4);
    }

    // recv int index to switch to the corresponding player
    // 1 represents player1, 2 represents player2, 3 represents player3
    // ...
    /**
     * util function to switch to the corresponding player.
     * @param index
     */
    private void Switch_player(int index) {
        System.out.println("Switch to player " + index);
        getInstance().gameState.setCharacter(index);
    }
}
