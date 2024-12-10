package multiplewindows;

import com.example.platformerplain.Start;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InformationController {
    public Button Information_closePage;

    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        Start.setRoot("home");
    }
}
