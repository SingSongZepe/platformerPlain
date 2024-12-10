package multiplewindows;

import javafx.event.ActionEvent;

import java.io.IOException;

public class InformationController {
    public void Switch_toHome(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Home");
    }
}
