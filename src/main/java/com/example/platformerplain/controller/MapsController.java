package com.example.platformerplain.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.example.platformerplain.Main.getInstance;

public class MapsController {
    @FXML
    public ImageView Maps_backgroundImage;
    @FXML
    public ImageView level1_image;
    @FXML
    public ImageView level2_image;
    @FXML
    public ImageView level3_image;
    @FXML
    public Button Maps_glacier_button;
    @FXML
    public Button Maps_forest_button;
    @FXML
    public Button Maps_desert_button;
    @FXML
    public ImageView Maps_closePage;

    /**
     * initializes the controller class
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        getInstance().setRoot("home");
    }

    /**
     * changes the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void Change_glacierImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level1_image.setEffect(glowEffect);
        level1_image.setEffect(shadowEffect);
        level1_image.setFitHeight(200);
        level1_image.setFitWidth(280);
    }

    /**
     * changes the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void Change_desertImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level2_image.setEffect(glowEffect);
        level2_image.setEffect(shadowEffect);
        level2_image.setFitHeight(200);
        level2_image.setFitWidth(280);
    }

    /**
     * changes the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void Change_forestImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level3_image.setEffect(glowEffect);
        level3_image.setEffect(shadowEffect);
        level3_image.setFitHeight(200);
        level3_image.setFitWidth(280);
    }

    /**
     * remove the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void glacier_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level1_image.setEffect(glowEffect);
        level1_image.setEffect(shadowEffect);
        level1_image.setFitHeight(180);
        level1_image.setFitWidth(250);
    }

    /**
     * remove the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void desert_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level2_image.setEffect(glowEffect);
        level2_image.setEffect(shadowEffect);
        level2_image.setFitHeight(180);
        level2_image.setFitWidth(250);
    }

    /**
     * remove the effect of the background image of the maps page
     * @param event
     */
    @FXML
    public void forest_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level3_image.setEffect(glowEffect);
        level3_image.setEffect(shadowEffect);
        level3_image.setFitHeight(180);
        level3_image.setFitWidth(250);
    }

    /**
     * switches to game level 1 when button is clicked
     * @param actionEvent
     */
    @FXML
    public void Switch_GameLevel1(ActionEvent actionEvent) {
        System.out.println("Switch to Game Level 1");
        getInstance().gameState.setMap(1);
    }

    /**
     * switches to game level 2 when button is clicked
     * @param actionEvent
     */
    @FXML
    public void Switch_GameLevel2(ActionEvent actionEvent) {
        System.out.println("Switch to Game Level 2");
        getInstance().gameState.setMap(2);
    }

    /**
     * switches to game level 3 when button is clicked
     * @param actionEvent
     */
    @FXML
    public void Switch_GameLevel3(ActionEvent actionEvent) {
        System.out.println("Switch to Game Level 3");
        getInstance().gameState.setMap(3);
    }
}
