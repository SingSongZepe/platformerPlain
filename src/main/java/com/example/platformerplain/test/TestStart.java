package com.example.platformerplain.test;

import com.example.platformerplain.Start;

import java.io.IOException;

import static com.example.platformerplain.Start.getInstance;

public class TestStart {

    public static void main(String[] args) throws IOException {
        Start.main(args);
        getInstance().setRoot("score");
    }
}
