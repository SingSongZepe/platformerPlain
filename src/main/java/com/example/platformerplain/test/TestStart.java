package com.example.platformerplain.test;

import com.example.platformerplain.Main;

import java.io.IOException;

import static com.example.platformerplain.Main.getInstance;

public class TestStart {

    public static void main(String[] args) throws IOException {
        Main.main(args);
        getInstance().setRoot("score");
    }
}
