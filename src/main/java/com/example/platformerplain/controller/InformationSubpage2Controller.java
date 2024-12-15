package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InformationSubpage2Controller {
    public void return_toInformation(MouseEvent mouseEvent) throws IOException {
        Start.getInstance().setRoot("information");
    }
}
