package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static com.example.platformerplain.Start.getInstance;

public class InformationController {

    public ImageView Information_closePage;
    public Button info_introbutton;
    public Button info_level1button;
    public Button info_level2button;
    public Pane ContentArea;

    /**
     * This method is used to initialize the controller class.
     * @param mouseEvent
     * @throws IOException
     */
    public void Switch_toHome(MouseEvent mouseEvent) throws IOException {
        getInstance().setRoot("home");
    }

    /**
     * This method is used to switch to the intro page.
     * @param actionEvent
     * @throws IOException
     */
    public void switch_intro(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(Start.loadFXML("information_subpage1"));
    }

    /**
     * This method is used to switch to the level 1 page.
     * @param actionEvent
     * @throws IOException
     */
    public void switch_level1(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(Start.loadFXML("information_subpage2"));
    }

    /**
     * This method is used to switch to the level 2 page.
     * @param actionEvent
     * @throws IOException
     */
    public void switch_level2(MouseEvent actionEvent) throws IOException {
        ContentArea.getChildren().clear();
        ContentArea.getChildren().add(Start.loadFXML("information_subpage3"));
    }
}
