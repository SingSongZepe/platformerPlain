package com.example.platformerplain;

import com.example.platformerplain.controller.PlayerController;
import com.example.platformerplain.object.*;
import com.example.platformerplain.utils.InitContent;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.media.*;
import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Singleton class that starts the game.
 * scene is the root node of the game.
 */
public class Start extends Application {

    private static Start instance;

    /**
     * Initialize the game by setting the game state.
     * @throws Exception if there is any error in initialization
     */
    @Override
    public void init() throws Exception {
        super.init();
        instance = this; // Set the singleton instance
        gameState = new GameState();
    }

    /**
     * Return the singleton instance of the game.
     * @return the singleton instance of the game
     */
    public static Start getInstance() {
        return instance;
    }

    public static Scene scene;
    private static MediaPlayer mediaPlayer;
    // record the information of the condition of the game
    public static GameState gameState;
    // use for the game logic
    private static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    public static ArrayList<Node> platforms = new ArrayList<>();
    public static ArrayList<FeatureNode> featureNodes = new ArrayList<>();
    public static ArrayList<SupplyNode> supplyNodes = new ArrayList<>();
    public static DestinationNode destinationNode;
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    public static Pane uiRoot = new Pane();

    public static PlayerController playerController;
    public static AnimationTimer timer;

    /**
     * Start the game by loading the start scene.
     * @param primaryStage the primary stage of the game
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // start page
        // ! test here
        scene = new Scene(loadFXML("start"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("ESCAPE BEYOND!");
        primaryStage.show();
        // maintain the size of the window
        // 1280 x 720
        primaryStage.setResizable(false);
        primaryStage.setWidth(1280);
        primaryStage.setHeight(720);
    }

    /**
     * Set the root of the scene to the specified fxml file.
     * @param fxml
     * @throws IOException
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Load the specified fxml file and return the root node of the scene.
     * @param fxml the name of the fxml file to load
     * @return the root node of the scene
     * @throws IOException if there is any error in loading the fxml file
     */
    public static Parent loadFXML(String fxml) throws IOException {
        URL resource = Start.class.getResource("/fxml/" + fxml + ".fxml");
        if (resource == null) {
            System.err.println("Cannot find resource for fxml: " + fxml);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }

    /**
     * Play the background music of the game.
     */
    public static void main(String[] args) {
        launch(args);
    }

    // make it a static variable to access it.
    public static final Label timerLabel = new Label();

    // when countdown is over
    public static void onCountdownEnd(int i) {
        // Logic to execute when the countdown ends
        System.out.println("Countdown finished!"); // Placeholder for your callback logic
        // ! TODO You can add more logic here, like transitioning to another scene or showing a game over screen
        try {
            Start.setRoot("game_over");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Start the game by loading the game scene.
     * @throws IOException
     */
    public static void startGame() throws IOException {
        clearContentStates();

        scene.setRoot(appRoot);

        InitContent.initContent();
    }

    /**
     * Quit the game by clearing all the data of a map(game).
     * @throws IOException
     */
    public static void quitGame() throws IOException {
        // clear all the data of a map(game)
        clearContentStates();
        gameState = new GameState();

        if (timer != null) {
            timer.stop();
        }
        Start.setRoot("home");
    }

    /**
     * when you lose the game
     * clear all the data of a map(game) and go to game over scene
     * @throws IOException
     */
    public static void gameOver() throws IOException {
        // clear all the data of a map(game)
        clearContentStates();
        gameState = new GameState();

        if (timer != null) {
            timer.stop();
        }
        Start.setRoot("game_over");
    }

    /**
     * when you win the game
     * clear all the data of a map(game) and go to score scene
     * @throws IOException
     */
    public static void gameWin() throws IOException {

        // there we add the time used to gameState
        String timeFormatted = timerLabel.getText().split(" ")[2];
        // covert mm:ss to seconds
        int time = Integer.parseInt(timeFormatted.split(":")[0]) * 60 + Integer.parseInt(timeFormatted.split(":")[1]);
        gameState.spentTime = time;

        if (timer != null) {
            timer.stop();
        }
        // clear all the data of a map(game)
        clearContentStates();
        Start.setRoot("score");
    }

    private static void clearContentStates() {
        platforms.clear();
        featureNodes.clear();
        gameRoot = new Pane();
        appRoot = new Pane();
        uiRoot = new Pane();
        playerController = null;
    }
}
