package com.example.platformerplain.utils;

import javafx.scene.layout.Pane;
import java.io.IOException;

/**
 * use adapter design pattern to initialize content
 */
public class InitContent {

    private static final InitContentAdapter adapter = new InitContentAdapter();

    /**
     * according to the different map index, initialize the content
     * modifies the content of the appRoot
     * so do not return anything
     */
    public static void initContent() throws IOException {
        adapter.initContent();
    }
}
