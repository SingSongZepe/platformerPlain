import com.example.platformerplain.object.Score;
import com.example.platformerplain.object.ScoreManager;
import com.example.platformerplain.object.Value;

import java.util.ArrayList;
import java.util.List;

public class TestScoreManager {

    public static void main(String[] args) {
        String filename = Value.SCORES_FILE;

        // print the current working directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        List<Score> scoresToSave = new ArrayList<>();
        scoresToSave.add(new Score(100, 1, "Level 1", "2024-12-11"));
        scoresToSave.add(new Score(200, 2, "Level 2", "2024-12-12"));

        ScoreManager.serializeScores(scoresToSave, filename);

        List<Score> loadedScores = ScoreManager.deserializeScores(filename);

        for (Score score : loadedScores) {
            System.out.println(score);
        }
    }
}