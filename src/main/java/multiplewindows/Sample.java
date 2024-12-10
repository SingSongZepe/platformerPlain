package multiplewindows;

import com.example.platformerplain.Start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Sample {
    @FXML
    public Pane ContentArea;
    @FXML
    public ImageView Option_closePage;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character.fxml")));
            ContentArea.getChildren().removeAll();
            ContentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void Switch_characterPage(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character.fxml")));
        ContentArea.getChildren().removeAll();
        ContentArea.getChildren().setAll(fxml);
    }

    @FXML
    public void Switch_voicePage(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("voice.fxml")));
        ContentArea.getChildren().removeAll();
        ContentArea.getChildren().setAll(fxml);
    }

    @FXML
    public void Switch_ThemePage(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("theme.fxml")));
        ContentArea.getChildren().removeAll();
        ContentArea.getChildren().setAll(fxml);
    }

    @FXML
    public void Close_OptionPage(MouseEvent event) throws IOException {
        Start.setRoot("home");
    }
}
