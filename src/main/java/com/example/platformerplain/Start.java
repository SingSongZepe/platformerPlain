package com.example.platformerplain;

import com.example.platformerplain.object.GameState;
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
import java.net.URL;
import java.io.File;
import java.io.IOException;


public class Start extends Application {

    static Scene scene;
    MediaPlayer mediaPlayer;
    // record the information of the condition of the game
    static GameState gameState;

    /**
     * Initialize the game by setting the game state.
     * @throws Exception if there is any error in initialization
     */
    @Override
    public void init() throws Exception {
        gameState = GameState.getInstance();
//        System.out.println(gameState.getCharacter().Name);
    }

    /**
     * Start the game by loading the start scene.
     * @param primaryStage the primary stage of the game
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = new Scene(loadFXML("start"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome to ESCAPE BEYOND!");
        primaryStage.show();
    }

    /**
     * Set the root of the scene to the specified fxml file.
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL resource = Start.class.getResource("/fxml/" + fxml + ".fxml");
        if (resource == null) {
            System.err.println("Cannot find resource for fxml: " + fxml);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
