package com.example.platformerplain.object;

import com.example.platformerplain.Start;
import com.example.platformerplain.object.Score;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class ScoreManager {

    public static void serializeScores(List<Score> scores, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(scores);
            System.out.println("Scores serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static File getFileFromResources(String fileName) {
//        ClassLoader classLoader = Start.class.getClassLoader();
//        URL resource = classLoader.getResource(fileName);
//        if (resource == null) {
//            throw new IllegalArgumentException("File not found: " + fileName);
//        }
//        return new File(resource.getFile());
//    }

    // 从文件反序列化 Score 对象
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
//
//    private static InputStream getResourceAsStream(String fileName) {
//        InputStream inputStream = ScoreManager.class.getClassLoader().getResourceAsStream(fileName);
//        if (inputStream == null) {
//            throw new IllegalArgumentException("File not found: " + fileName);
//        }
//        return inputStream;
//    }
//
//    @SuppressWarnings("unchecked")
//    public static List<Score> deserializeScoresUsingStream(String filename) {
//        List<Score> scores = null;
//        try (ObjectInputStream ois = new ObjectInputStream(getResourceAsStream(filename))) {
//            scores = (List<Score>) ois.readObject();
//            System.out.println("Scores deserialized successfully");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return scores;
//    }
}