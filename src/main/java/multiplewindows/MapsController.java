package multiplewindows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MapsController {
    @FXML
    public ImageView Maps_backgroundImage;
    @FXML
    public ImageView level1_image;
    @FXML
    public ImageView level2_image;
    @FXML
    public ImageView level3_image;
    @FXML
    public Button Maps_glacier_button;
    @FXML
    public Button Maps_forest_button;
    @FXML
    public Button Maps_desert_button;
    @FXML
    public ImageView Maps_closePage;


    /*当点击Switch_toHome按钮时返回到前一页 即Home Page*/
    @FXML
    public void Switch_toHome(MouseEvent actionEvent) throws IOException {
        Main.setRoot("Home");
    }

    /*添加当鼠标enter button时的图片效果*/

    @FXML
    // 当鼠标点击时添加图片点击效果
    public void Change_glacierImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level1_image.setEffect(glowEffect);
        level1_image.setEffect(shadowEffect);
        level1_image.setFitHeight(200);
        level1_image.setFitWidth(280);
    }

    @FXML
    // 当鼠标点击时添加图片点击效果
    public void Change_desertImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level2_image.setEffect(glowEffect);
        level2_image.setEffect(shadowEffect);
        level2_image.setFitHeight(200);
        level2_image.setFitWidth(280);
    }

    @FXML
    // 当鼠标点击时添加图片点击效果
    public void Change_forestImageEffect(MouseEvent event) {
        Glow glowEffect = new Glow(0.5);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(15.0);
        shadowEffect.setOffsetY(15.0);
        level3_image.setEffect(glowEffect);
        level3_image.setEffect(shadowEffect);
        level3_image.setFitHeight(200);
        level3_image.setFitWidth(280);
    }

    /*添加当鼠标exit button时的图片效果(恢复初始状态)*/
    @FXML
    public void glacier_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level1_image.setEffect(glowEffect);
        level1_image.setEffect(shadowEffect);
        level1_image.setFitHeight(180);
        level1_image.setFitWidth(250);
    }

    @FXML
    public void desert_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level2_image.setEffect(glowEffect);
        level2_image.setEffect(shadowEffect);
        level2_image.setFitHeight(180);
        level2_image.setFitWidth(250);
    }

    @FXML
    public void forest_mouseExited(MouseEvent event) {
        Glow glowEffect = new Glow(0);
        DropShadow shadowEffect = new DropShadow();
        shadowEffect.setOffsetX(0.0);
        shadowEffect.setOffsetY(0.0);
        level3_image.setEffect(glowEffect);
        level3_image.setEffect(shadowEffect);
        level3_image.setFitHeight(180);
        level3_image.setFitWidth(250);
    }

    /*添加当鼠标点击相应level button时跳转至相对应的Game Level page*/
    @FXML
    public void Switch_GameLevel1(ActionEvent actionEvent) {
    }

    @FXML
    public void Switch_GameLevel3(ActionEvent actionEvent) {
    }

    @FXML
    public void Switch_GameLevel2(ActionEvent actionEvent) {
    }
}
