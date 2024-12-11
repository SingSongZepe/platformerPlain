package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import com.example.platformerplain.object.Score;
import com.example.platformerplain.object.ScoreManager;
import com.example.platformerplain.object.Value;
import com.example.platformerplain.utils.File;
import com.example.platformerplain.utils.ScoreCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import javafx.scene.input.MouseEvent;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.example.platformerplain.Start.loadFXML;

public class ScoreController {

    @FXML
    private Text currentScoreText;
    @FXML
    private Text highScoreText;
    @FXML
    private Button returnToMenuButton;

    private List<Score> loadedScores;

    public void initialize() {
        System.out.println("score.fxml initialized");

        returnToMenuButton.setOnMouseEntered(event -> {
            returnToMenuButton.setStyle("-fx-background-color: #E0FFFF; -fx-text-fill: black;");
        });

        returnToMenuButton.setOnMouseExited(event -> {
            returnToMenuButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white;");
        });

        returnToMenuButton.setCursor(javafx.scene.Cursor.HAND);

        int currentScore = ScoreCalculator.calculateScore(Start.gameState);
        currentScoreText.setText(String.valueOf(currentScore));

        int highScore = loadHighScore();
        highScoreText.setText(String.valueOf(highScore));

        // check if current score is higher than high score
        // if yes, update high score in to the file
        int map_index = Start.gameState.map.index;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String date = now.format(formatter);

        if (currentScore > highScore) {
            loadedScores.set(
                    map_index-1,
                    new Score(
                            currentScore,
                            Start.gameState.map.index,
                            Start.gameState.map.map_name,
                            date
                    )
            );
        }
        try {
            String filename = Value.SCORES_FILE;
            ScoreManager.serializeScores(loadedScores, filename);
        } catch (Exception e) {
            System.out.println("Error writing highscore file: " + e.getMessage());
        }
    }

    private int loadHighScore() {
        int score = 0;
        try {
            String filename = Value.SCORES_FILE;

            loadedScores = ScoreManager.deserializeScores(filename);
            System.out.println("Loaded scores: " + loadedScores);
            // find the highest score
            int map_index = Start.gameState.map.index;

            return loadedScores.get(map_index-1).getScore();

        } catch (Exception e) {
            System.out.println("Error reading highscore file: " + e.getMessage());

        }

        return score;
    }

    @FXML
    public void Switch_toHome(ActionEvent actionEvent) throws IOException {
        Start.setRoot("home");
    }
}