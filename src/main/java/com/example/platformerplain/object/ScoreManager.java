package com.example.platformerplain.object;

import com.example.platformerplain.Start;
import com.example.platformerplain.object.Score;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class ScoreManager {

    /**
     * Serialize scores to file
     * @param scores
     * @param filename
     */
    public static void serializeScores(List<Score> scores, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(scores);
            System.out.println("Scores serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserialize scores from file
     * @param filename
     * @return List of scores
     */
    @SuppressWarnings("unchecked")
    public static List<Score> deserializeScores(String filename) {
        List<Score> scores = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            scores = (List<Score>) ois.readObject();
            System.out.println("Scores deserialized successfully");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return scores;
    }
}