package com.example.platformerplain.object;

import java.io.Serializable;

public class Score implements Serializable {
    private static final long serialVersionUID = 1L; // 确保版本一致
    private int score;
    private int map_index;
    private String map_name;
    private String date;

    /**
     * Constructor for Score object
     * @param score
     * @param map_index
     * @param map_name
     * @param date
     */
    public Score(int score, int map_index, String map_name, String date) {
        this.score = score;
        this.map_index = map_index;
        this.map_name = map_name;
        this.date = date;
    }

    // Getters
    public int getScore() {
        return score;
    }

    public int getMapIndex() {
        return map_index;
    }

    public String getMapName() {
        return map_name;
    }

    public String getDate() {
        return date;
    }

    /**
     * transform the object to a string
     * @return
     */
    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", map_index=" + map_index +
                ", map_name='" + map_name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}