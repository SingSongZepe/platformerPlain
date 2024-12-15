package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InformationSubpage2Controller {

    /**
     * This method is called when the user clicks the "Return to Information"
     * button on the second subpage of the information page.
     * @param mouseEvent
     * @throws IOException
     */
    public void return_toInformation(MouseEvent mouseEvent) throws IOException {
        Start.getInstance().setRoot("information");
    }
}
