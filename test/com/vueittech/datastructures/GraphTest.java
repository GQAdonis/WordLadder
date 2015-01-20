package com.vueittech.datastructures;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphTest {
    
    private Graph graph;

    @Before
    public void setUp() throws Exception {
        Vector<String> words = new Vector<String>();
        
        words.add("eight");
        words.add("bight");
        words.add("bigot");
        words.add("sight");
        words.add("swank");
        
        graph = new Graph(words);
    }

    @Test
    public void testGetOutputStack() throws Exception {
        graph.breadthFirstSearch("eight", "bigot");

        Stack<Node> outputStack = graph.getOutputStack();
        assertTrue(outputStack != null);
        assertTrue(outputStack.size() == 3);

        Iterator<Node> iterator = outputStack.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            
            Node node = iterator.next();
            System.out.println(node.getNodeString());
            
            if (i == 0) {
                assertTrue(node.getNodeString().equals("bigot"));
            } else if (i == 1) {
                assertTrue(node.getNodeString().equals("bight"));
            } else if (i == 2) {
                assertTrue(node.getNodeString().equals("eight"));
            }
            
            ++i;
        }
    }

    @Test
    public void testCreateGraph() throws Exception {

        Hashtable<String, Node> nodeHashtable = graph.getNodeMap();
        
        assertTrue(nodeHashtable.size() == 5);
        assertTrue(nodeHashtable.containsKey("eight"));
        assertTrue(nodeHashtable.containsKey("bight"));
        assertTrue(nodeHashtable.containsKey("bigot"));
        assertTrue(nodeHashtable.containsKey("sight"));
        assertTrue(nodeHashtable.containsKey("swank"));
    }

    @Test
    public void testBreadthFirstSearch() throws Exception {

        assertTrue(graph.breadthFirstSearch("eight", "bigot"));
    }

    @Test
    public void testBreadthFirstSearchFailed() throws Exception {

        assertFalse(graph.breadthFirstSearch("booty", "bigot"));
    }

    @Test
    public void testBreadthFirstSearchFailedNoConnection() throws Exception {

        assertFalse(graph.breadthFirstSearch("eight", "swank"));
    }

    @Test
    public void testCheckWordConnection() throws Exception {
        assertTrue(graph.checkWordConnection("eight", "bight"));
    }

    @Test
    public void testCheckWordConnectionFailedLength() throws Exception {
        assertFalse(graph.checkWordConnection("eight", "ight"));
    }

    @Test
    public void testCheckWordConnectionFailedNoConenction() throws Exception {
        assertFalse(graph.checkWordConnection("eight", "swank"));
    }

    @Test
    public void testGetNodeForWord() throws Exception {
        Node node = graph.getNodeForWord("bigot");
        assertTrue(node != null);
        assertTrue(node.getNodeString().equals("bigot"));
    }

    @Test
    public void testReset() throws Exception {
        graph.reset();
        
        Hashtable<String, Node> nodeHashtable = graph.getNodeMap();
        
        Enumeration<String> keys = nodeHashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            
            Node node = nodeHashtable.get(key);
            assertFalse(node.hasBeenVisited());
        }
    }
}