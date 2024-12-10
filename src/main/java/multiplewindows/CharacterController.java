package multiplewindows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CharacterController {
    @FXML
    public Button character1_button;
    @FXML
    public Button character2_button;
    @FXML
    public Button character3_button;
    @FXML
    public Button character4_button;
    @FXML
    public ImageView character1;
    @FXML
    public ImageView character2;
    @FXML
    public ImageView character3;
    @FXML
    public ImageView character4;

    /*添加当鼠标click button时的图片效果*/

    @FXML
    public void choose_character1(ActionEvent actionEvent) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(10.0);
        shadowEffect.setOffsetY(10.0);
        character1.setEffect(glowEffect);
        character1.setEffect(shadowEffect);
        character1.setFitHeight(300);
        character1.setFitWidth(170);
    }

    @FXML
    public void choose_character2(ActionEvent actionEvent) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(10.0);
        shadowEffect.setOffsetY(10.0);
        character2.setEffect(glowEffect);
        character2.setEffect(shadowEffect);
        character2.setFitHeight(300);
        character2.setFitWidth(170);
    }

    @FXML
    public void choose_character3(ActionEvent actionEvent) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(10.0);
        shadowEffect.setOffsetY(10.0);
        character3.setEffect(glowEffect);
        character3.setEffect(shadowEffect);
        character3.setFitHeight(300);
        character3.setFitWidth(170);
    }

    @FXML
    public void choose_character4(ActionEvent actionEvent) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(10.0);
        shadowEffect.setOffsetY(10.0);
        character4.setEffect(glowEffect);
        character4.setEffect(shadowEffect);
        character4.setFitHeight(300);
        character4.setFitWidth(170);
    }

    /*添加当鼠标exit button时的图片效果(恢复初始状态)*/

    @FXML
    public void mouseExited_character1(MouseEvent event) {
        Glow glowEffect = new Glow(0.0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        character1.setEffect(glowEffect);
        character1.setEffect(shadowEffect);
        character1.setFitHeight(295);
        character1.setFitWidth(166);
    }

    @FXML
    public void mouseExited_character2(MouseEvent event) {
        Glow glowEffect = new Glow(0.0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        character2.setEffect(glowEffect);
        character2.setEffect(shadowEffect);
        character2.setFitHeight(295);
        character2.setFitWidth(194);
    }

    @FXML
    public void mouseExited_character3(MouseEvent event) {
        Glow glowEffect = new Glow(0.0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        character3.setEffect(glowEffect);
        character3.setEffect(shadowEffect);
        character3.setFitHeight(298);
        character3.setFitWidth(159);
    }

    @FXML
    public void mouseExited_character4(MouseEvent event) {
        Glow glowEffect = new Glow(0.0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        character4.setEffect(glowEffect);
        character4.setEffect(shadowEffect);
        character4.setFitHeight(302);
        character4.setFitWidth(131);
    }
}
