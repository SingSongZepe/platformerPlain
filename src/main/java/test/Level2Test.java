package test;

import com.example.platformerplain.Main;
import com.example.platformerplain.object.Character;
import com.example.platformerplain.object.Map;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Level2Test {

    @Test
    public void level1Test() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Main main = Main.getInstance();

            main.gameState.map = new Map(2);
            main.gameState.character = new Character();

            Platform.runLater(() -> {
                try {
                    main.startGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                main.setRoot("score");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}