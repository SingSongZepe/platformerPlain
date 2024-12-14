package com.example.platformerplain.object;

import javafx.scene.Node;

public class DestinationNode {

    public Node node;
    public String destinationType;

    public DestinationNode(String destinationType, Node node) {
        this.node = node;
        this.destinationType = destinationType;
    }
}
