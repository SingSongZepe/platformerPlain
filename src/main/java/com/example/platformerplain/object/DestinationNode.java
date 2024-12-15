package com.example.platformerplain.object;

import javafx.scene.Node;

public class DestinationNode {

    public Node node;
    public String destinationType;

    /**
     * constructor for DestinationNode
     * @param destinationType
     * @param node
     */
    public DestinationNode(String destinationType, Node node) {
        this.node = node;
        this.destinationType = destinationType;
    }
}
