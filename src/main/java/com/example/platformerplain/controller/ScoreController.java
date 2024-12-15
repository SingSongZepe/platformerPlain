package com.example.platformerplain.controller;

import com.example.platformerplain.Start;
import com.example.platformerplain.object.Score;
import com.example.platformerplain.object.ScoreManager;
import com.example.platformerplain.object.Value;
import com.example.platformerplain.utils.ScoreCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.example.platformerplain.Start.getInstance;

public class ScoreController {

    @FXML
    private Text currentScoreText;
    @FXML
    private Text highScoreText;
    @FXML
    private Button returnToMenuButton;

    private List<Score> loadedScores;

    /**
     * when load the score.fxml, initialize the score controller
     */
    public void initialize() {
        System.out.println("score.fxml initialized");

        returnToMenuButton.setOnMouseEntered(event -> {
            returnToMenuButton.setStyle("-fx-background-color: #E0FFFF; -fx-text-fill: black;");
        });

        returnToMenuButton.setOnMouseExited(event -> {
            returnToMenuButton.setStyle("-fx-background-color: #00CED1; -fx-text-fill: white;");
        });

        returnToMenuButton.setCursor(javafx.scene.Cursor.HAND);

        int currentScore = ScoreCalculator.calculateScore(getInstance().gameState);
        currentScoreText.setText(String.valueOf(currentScore));

        int highScore = loadHighScore();
        highScoreText.setText(String.valueOf(highScore));

        // check if current score is higher than high score
        // if yes, update high score in to the file
        int map_index = getInstance().gameState.map.index;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String date = now.format(formatter);

        // when size of loadedScores is not 3
        // add new Score object to loadedScores
        // it should contain all 3 maps
        // map_index == 1, 2, 3
        int[] existing_scores = {0, 0, 0};
        for (Score score: loadedScores) {
            existing_scores[score.getMapIndex()-1] = 1;
        }

        for (int i = 0; i < 3; i++) {
            if (existing_scores[i] == 0) {
                loadedScores.add(i, new Score(0, i+1, "", "0000-00-00 00:00:00"));
            }
        }

        if (currentScore > highScore) {
            loadedScores.set(
                map_index-1,
                new Score(
                    currentScore,
                    getInstance().gameState.map.index,
                    getInstance().gameState.map.map_name,
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

    /**
     * load high score from file
     * @return
     */
    private int loadHighScore() {
        int score = 0;
        try {
            String filename = Value.SCORES_FILE;

            loadedScores = ScoreManager.deserializeScores(filename);
            System.out.println("Loaded scores: " + loadedScores);
            // find the highest score
            int map_index = getInstance().gameState.map.index;

            return loadedScores.get(map_index-1).getScore();

        } catch (Exception e) {
            System.out.println("Error reading highscore file: " + e.getMessage());

        }

        return score;
    }

    /**
     * return to home page
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void Switch_toHome(ActionEvent actionEvent) throws IOException {
        getInstance().setRoot("home");
    }
}