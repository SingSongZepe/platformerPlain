module com.example.platformerplain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires javafx.media;
    requires junit;
    requires org.testng;
    requires org.testfx;
    requires org.testfx.junit;
    requires testfx.junit5;
    requires org.junit.jupiter.api;

    opens com.example.platformerplain to javafx.fxml, junit; // Open your package for reflection
    exports com.example.platformerplain;
    exports com.example.platformerplain.controller;
    opens com.example.platformerplain.controller to javafx.fxml;
    exports com.example.platformerplain.object;
    opens com.example.platformerplain.object to javafx.fxml;
    exports test;
}
