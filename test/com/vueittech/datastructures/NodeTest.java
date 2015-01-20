package com.vueittech.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.*;

public class NodeTest {
    private Node node;

    @Before
    public void setUp() throws Exception {
        node = new Node();
        node.setNodeString("eight");
        node.setHasBeenVisited(false);
        
    }

    @Test
    public void testGetNodeString() throws Exception {

        assertTrue(node.getNodeString().equals("eight"));
    }

    @Test
    public void testSetNodeString() throws Exception {

        Node testNode = new Node();
        testNode.setNodeString("bight");
        assertTrue(testNode.getNodeString().equals("bight"));
    }

    @Test
    public void testGetConnectedNodes() throws Exception {

        Node testNode = new Node();
        testNode.setNodeString("bight");
        testNode.addLink(node);
        
        assertTrue(testNode.getConnectedNodes().size() == 1);
        assertTrue(testNode.getConnectedNodes().get(0).equals(node));
    }

    @Test
    public void testSetConnectedNodes() throws Exception {

        Node testNode = new Node();
        testNode.setNodeString("eight");

        Vector<Node> testVector = new Vector<Node>();
        Node n = new Node();
        n.setNodeString("bight");
        testVector.add(n);
        
        n = new Node();
        n.setNodeString("sight");
        testVector.add(n);
        
        testNode.setConnectedNodes(testVector);

        assertTrue(testNode.getConnectedNodes().size() == 2);
        assertTrue(testNode.getConnectedNodes().get(0).getNodeString().equals("bight"));
        assertTrue(testNode.getConnectedNodes().get(1).getNodeString().equals("sight"));
    }

    @Test
    public void testHasBeenVisited() throws Exception {

        Node testNode = new Node();
        testNode.setHasBeenVisited(false);
        
        assertFalse(testNode.hasBeenVisited());
    }

    @Test
    public void testSetHasBeenVisited() throws Exception {

        node.setHasBeenVisited(true);
        assertTrue(node.hasBeenVisited());
    }

    @Test
    public void testGetParent() throws Exception {

        Node testNode = new Node();
        testNode.setNodeString("bight");
        testNode.setParent(node);
        
        assertTrue(testNode.getParent().equals(node));
    }

    @Test
    public void testSetParent() throws Exception {

        testGetParent();
    }

    @Test
    public void testAddLink() throws Exception {
        testGetConnectedNodes();
    }
}