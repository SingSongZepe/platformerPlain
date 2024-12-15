package com.example.platformerplain;

import com.example.platformerplain.controller.PlayerController;
import com.example.platformerplain.object.*;
import com.example.platformerplain.object.MovableNode;
import com.example.platformerplain.utils.InitContent;
import com.example.platformerplain.utils.IntArrayIterator;
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
import java.util.Objects;

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

        rangeIterator = null;

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    playerController.update();
                    for (MovableNode movableNode : movableNodes) {
                        movableNode.step_move();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    /**
     * Return the singleton instance of the game.
     * @return the singleton instance of the game
     */
    public static Start getInstance() {
        return instance;
    }

    public Scene scene;
    private MediaPlayer mediaPlayer;
    // record the information of the condition of the game
    public GameState gameState;
    // use for the game logic
    private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    public ArrayList<Node> platforms = new ArrayList<>();
    public ArrayList<FeatureNode> featureNodes = new ArrayList<>();
    public ArrayList<SupplyNode> supplyNodes = new ArrayList<>();
    public DestinationNode destinationNode;
    //
    public ArrayList<MovableNode> movableNodes = new ArrayList<>();
    public ArrayList<EnemyNode> enemyNodes = new ArrayList<>();

    public Pane appRoot = new Pane();
    public Pane gameRoot = new Pane();
    public Pane uiRoot = new Pane();

    public PlayerController playerController;
    public AnimationTimer timer;

    public AnimationTimer timerLabelTimer;

    // use to initialize the ranges of movable objects
    public IntArrayIterator rangeIterator;

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
    public void setRoot(String fxml) throws IOException {
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

    /**
     * Callback function when the countdown ends.
     * and go to game over scene
     * @param i
     */
    public static void onCountdownEnd(int i) {
        // Logic to execute when the countdown ends
        System.out.println("Countdown finished!"); // Placeholder for your callback logic
        try {
            Start.getInstance().setRoot("game_over");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Restart the game by clearing all the data of a map(game) and loading the start scene.
     * @throws IOException
     */
    public void restartGame() throws IOException {
        clearContentStates();

        scene.setRoot(appRoot);

        InitContent.initContent();

        playMusic();
    }

    /**
     * Start the game by loading the game scene.
     * @throws IOException
     */
    public void startGame() throws IOException {
        clearContentStates();

        scene.setRoot(appRoot);

        InitContent.initContent();

        playMusic();
    }

    /**
     * Quit the game by clearing all the data of a map(game).
     * @throws IOException
     */
    public void quitGame() throws IOException {
        // clear all the data of a map(game)
        clearContentStates();
        gameState.clear();

        timer.stop();

        setRoot("home");
    }

    /**
     * when you lose the game
     * clear all the data of a map(game) and go to game over scene
     * @throws IOException
     */
    public static void gameOver() throws IOException {
        // clear all the data of a map(game)
        getInstance().gameState.reset();

        getInstance().timer.stop();

        clearContentStates();
        getInstance().setRoot("game_over");
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
        // use regex to extract the time from the label
        String timePattern = "(\\d+):(\\d+)";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(timePattern);
        java.util.regex.Matcher matcher = pattern.matcher(timeFormatted);

        int totalSeconds = 0;

        if (matcher.find()) {
            int minutes = Integer.parseInt(matcher.group(1));
            int seconds = Integer.parseInt(matcher.group(2));

            totalSeconds = minutes * 60 + seconds;
        } else {
            throw new RuntimeException("Invalid time format: " + timeFormatted);
        }
        int spentTime = GameState.TOTAL_TIME - totalSeconds;
        getInstance().gameState.spentTime = spentTime;

        getInstance().timer.stop();

        // clear all the data of a map(game)
        clearContentStates();
        getInstance().setRoot("score");
    }

    /**
     * clear all the data of a map(game)
     */
    private static void clearContentStates() {

        // Stop and release the media player
        if (getInstance().mediaPlayer != null) {
            getInstance().mediaPlayer.stop();
            getInstance().mediaPlayer.dispose();
            getInstance().mediaPlayer = null;
        }

        // Stop and release the timerLabelTimer
        if (getInstance().timerLabelTimer != null) {
            getInstance().timerLabelTimer.stop();
            getInstance().timerLabelTimer = null;
        }

        getInstance().platforms.clear();
        getInstance().featureNodes.clear();
        getInstance().supplyNodes.clear();
        getInstance().destinationNode = null;
        getInstance().movableNodes.clear();
        getInstance().enemyNodes.clear();
        getInstance().gameRoot = new Pane();
        getInstance().appRoot = new Pane();
        getInstance().uiRoot = new Pane();
        getInstance().playerController = null;
    }

    /**
     * play the corresponding music of the level game
     */
    public void playMusic() {
        // according to the map_index, load the corresponding bgm
        Media audioMedia = switch (gameState.map.index) {
            case 1 -> // level 1 glacier
                    new Media(Objects.requireNonNull(Start.class.getResource("/sounds/glacier_bgm.mp3")).toExternalForm());
            case 2 -> // level 2 desert
                    new Media(Objects.requireNonNull(Start.class.getResource("/sounds/desert_bgm.mp3")).toExternalForm());
            case 3 -> // level 3 forest
                    new Media(Objects.requireNonNull(Start.class.getResource("/sounds/glacier_bgm.mp3")).toExternalForm());
            default -> // default level 1 glacier
                    throw new RuntimeException("Invalid map index: " + gameState.map.index);
        };
        mediaPlayer = new MediaPlayer(audioMedia);
        mediaPlayer.setVolume(Value.MEDIAPLAYER_VOLUME);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
}
