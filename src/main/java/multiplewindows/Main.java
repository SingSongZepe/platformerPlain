package multiplewindows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.print.attribute.standard.Media;
import javafx.scene.media.*;
import java.io.File;
import java.io.IOException;


public class Main extends Application {

    static Scene scene;
    MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(loadFXML("Start"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome to ESCAPE BEYOND!");
        primaryStage.show();
    }
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
