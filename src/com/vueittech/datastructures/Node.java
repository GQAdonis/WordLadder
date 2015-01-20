package com.vueittech.datastructures;

import java.util.Vector;

/**
 * Created by gqadonis on 1/19/15.
 */
public class Node {
    private String nodeString;

    private Vector<Node> connectedNodes = new Vector<Node>();

    private boolean hasBeenVisited = false;

    private Node parent = null;

    public Node() {

    }

    public Node(String nodeString) {
        this.setNodeString(nodeString);
    }

    public String getNodeString() {
        return nodeString;
    }

    public void setNodeString(String nodeString) {
        this.nodeString = nodeString;
    }

    public Vector<Node> getConnectedNodes() {
        return connectedNodes;
    }

    public void setConnectedNodes(Vector<Node> connectedNodes) {
        this.connectedNodes = connectedNodes;
    }

    public boolean hasBeenVisited() {
        return hasBeenVisited;
    }

    public synchronized void setHasBeenVisited(boolean hasBeenVisited) {
        this.hasBeenVisited = hasBeenVisited;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addLink(Node newNode) {
        connectedNodes.add(newNode);
    }
}
