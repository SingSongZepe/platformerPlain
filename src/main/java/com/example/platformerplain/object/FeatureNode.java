package com.example.platformerplain.object;

import javafx.scene.Node;

public class FeatureNode {

    public Node node;
    public String featureType;

    public FeatureNode(String featureType, Node node) {
        this.featureType = featureType;
        this.node = node;
    }
}
