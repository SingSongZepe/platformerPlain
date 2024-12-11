package com.example.platformerplain;

import com.example.platformerplain.controller.PlayerController;
import com.example.platformerplain.object.GameState;
import com.example.platformerplain.object.Map;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.media.*;
import java.net.URL;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static com.example.platformerplain.utils.Counter.startCountdown;


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

    private static Scene scene;
    private static MediaPlayer mediaPlayer;
    // record the information of the condition of the game
    public static GameState gameState;
    // use for the game logic
    private static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    private static ArrayList<Node> platforms = new ArrayList<>();
    private static Pane appRoot = new Pane();
    private static Pane gameRoot = new Pane();
    private static Pane uiRoot = new Pane();

    private static PlayerController playerController;
    private static AnimationTimer timer;

    /**
     * Start the game by loading the start scene.
     * @param primaryStage the primary stage of the game
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // start page
        // ! test here
        scene = new Scene(loadFXML("score"));
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

    private static void initializeUi() throws IOException {
        // Create a VBox to hold the timer and exit button
        VBox uiContainer = new VBox();
        uiContainer.setSpacing(10);
        uiContainer.setAlignment(Pos.CENTER); // Center the content vertically
        uiContainer.setLayoutX(10); // Positioning
        uiContainer.setLayoutY(10);
        uiContainer.setPrefWidth(1280);
        uiContainer.setPrefHeight(80);

        // Create a label to display the timer
        Label timerLabel = new Label();
        timerLabel.setText("Time left: 5:00");
        timerLabel.setTextFill(Color.BLACK); // Set text color for visibility
        timerLabel.setStyle("-fx-font-size: 24px;");

        // Create an exit button
        Button exitButton = new Button("Exit Game");
        exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Set button color
        exitButton.setCursor(javafx.scene.Cursor.HAND); // Set cursor to hand

        // callback
        exitButton.setOnAction(event -> {
            System.out.println("quit game");
            try {
                quitGame();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // Add hover effects for the button
        exitButton.setOnMouseEntered(event -> {
            exitButton.setStyle("-fx-background-color: #40E0D0; -fx-text-fill: white; -fx-font-size: 16px;"); // Change color on hover
        });

        exitButton.setOnMouseExited(event -> {
            exitButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white; -fx-font-size: 16px;"); // Revert color
        });

        // Create a HBox to hold the timer label and exit button
        HBox hbox = new HBox();
        hbox.setSpacing(20); // Set spacing between elements
        hbox.setAlignment(Pos.CENTER); // Center the HBox content
        hbox.getChildren().addAll(timerLabel, exitButton); // Add the timer label and button to the HBox

        // Add the HBox to the UI container
        uiContainer.getChildren().add(hbox); // Add the HBox to the uiContainer

        // Add the UI container to the appRoot
        appRoot.getChildren().add(uiContainer); // Add the uiContainer to the appRoot

        // Start the countdown timer
        startCountdown(timerLabel);
    }

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

    // some utils methods
    private static void initContent(Scene scene) throws IOException {
        // load background picture
        ImageView bg = new ImageView(new Image(Objects.requireNonNull(
                Start.class.getResourceAsStream("/images/background/" + Map.getRandomMapBackground(gameState.map.index) + ".jpg")
        )));
        // Set the ImageView to stretch to 1280x720
        bg.setFitWidth(1280); // Set the width to 1280
        bg.setFitHeight(720); // Set the height to 720
        bg.setPreserveRatio(false); // Disable preserving the aspect ratio to stretch the image
        bg.setOpacity(0.5); // Set the opacity to 0.5

        // load level content
        String[] level = LevelData.Levels.get(gameState.map.index - 1);
        int levelWidth = level[0].length() * 60;  // Declare levelWidth in initContent() method directly

        for (int i = 0; i < level.length; i++){
            String line = level[i];
            for (int j=0; j <line.length();j++){
                switch (line.charAt(j)){
                    case '0':
                        break;
                    case '1':
                        Node platform = createEntity(j*60, i *60, 60, 60, Color.GREEN);
                        platforms.add(platform);
                        break;
                }
            }
        }

        playerController = new PlayerController(scene, gameRoot, platforms, levelWidth, gameState.character.index);  // Refactor Player using Observer Pattern
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                playerController.update();
            }
        };
        timer.start();
        appRoot.getChildren().addAll(bg, gameRoot);

        // load uiRoot
        initializeUi();
        appRoot.getChildren().add(uiRoot);
    }

    private static Node createEntity(int x, int y, int w, int h, Color color){
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(color);
        gameRoot.getChildren().add(entity);
        return entity;
    }

    // start the game
    public static void startGame() throws IOException {
        scene.setRoot(appRoot);
        initContent(scene);
    }

    // quit the game
    public static void quitGame() throws IOException {
        // clear all the data of a map(game)
        platforms.clear();
        gameRoot = new Pane();
        appRoot = new Pane();
        uiRoot = new Pane();
        gameState = new GameState();
        playerController = null;
        timer.stop();
        timer = null;

        Start.setRoot("home");
    }

    // when you lose the game
    public static void gameOver() throws IOException {
        // clear all the data of a map(game)
        platforms.clear();
        gameRoot = new Pane();
        appRoot = new Pane();
        uiRoot = new Pane();
        gameState = new GameState();
        playerController = null;
        timer.stop();
        timer = null;

        Start.setRoot("game_over");
    }

    // when you win the game
    public static void gameWin() throws IOException {
        // clear all the data of a map(game)
        platforms.clear();
        gameRoot = new Pane();
        appRoot = new Pane();
        uiRoot = new Pane();
        gameState = new GameState();
        playerController = null;
        timer.stop();
        timer = null;

        Start.setRoot("score");
    }
}
