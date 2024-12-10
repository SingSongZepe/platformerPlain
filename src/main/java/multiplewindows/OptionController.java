package multiplewindows;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class OptionController {
    public ImageView Option_closePage;

    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        Main.setRoot("Home");
    }
}
