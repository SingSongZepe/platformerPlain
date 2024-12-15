package test;

import com.example.platformerplain.Main;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class OptionPageTest {

    @Test
    public void optionPageTest() throws IOException {
        System.out.println("ScorePageTest");

        new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Main main = Main.getInstance();

            try {
                main.setRoot("option");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Main.main(new String[]{});
    }
}