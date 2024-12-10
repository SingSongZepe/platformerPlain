module com.example.platformerplain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires javafx.media;


    opens com.example.platformerplain to javafx.fxml;
    opens multiplewindows to javafx.fxml;
    exports com.example.platformerplain;
    exports multiplewindows;
    exports com.example.platformerplain.controller;
    opens com.example.platformerplain.controller to javafx.fxml;
}