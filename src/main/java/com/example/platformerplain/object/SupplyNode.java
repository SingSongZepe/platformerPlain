package com.example.platformerplain.object;

import javafx.scene.Node;

public class SupplyNode {

    public String SupplyType;
    public Node node;

    /**
     * constructor for SupplyNode
     * @param supplyType
     * @param node
     */
    public SupplyNode(String supplyType, Node node) {
        this.SupplyType = supplyType;
        this.node = node;
    }
}
