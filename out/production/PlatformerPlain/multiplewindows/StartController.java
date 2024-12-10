package multiplewindows;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Objects;

public class StartController {
    @FXML
    public Button button;
    @FXML
    public Pane Pane_Start;
    @FXML
    public ColorPicker Background_colorPicker;
    public ImageView Background_image;
    public ImageView Title_image;
    public Button Start_button_next;

    public void switchOnClicked(ActionEvent actionEvent) throws IOException {
        Main.setRoot("Home");
    }

    public void switch_background_color(ActionEvent actionEvent) {
        Color myColor = Background_colorPicker.getValue();
        Pane_Start.setBackground(new Background(new BackgroundFill(myColor,null,null)));
    }

}
