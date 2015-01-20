package com.vueittech.datastructures;

import java.util.*;


/**
 * Created by gqadonis on 1/19/15.
 */
public class Graph {
    private Hashtable<String, Node> nodeMap = new Hashtable<String, Node>();
    private Stack<Node> outputStack = new Stack<Node>();

    public Graph(Vector<String> validValues) {
        createGraph(validValues);

    }

    public Stack<Node> getOutputStack() {
        return outputStack;
    }

    public void createGraph(Vector<String> input) {

        //For every element in the vector of words
        for (String s : input) {

            //Create a new Node object to represent the current word
            Node newNode = new Node(s);

            //Iterate through existing elements in hash table
            Enumeration<String> e = nodeMap.keys();

            //Check that the has table size > 0
            if (nodeMap.size() > 0) {

                //For every existing Node in the hash table
                while (e.hasMoreElements()) {

                    String nextElement = e.nextElement();

                    // check to see if there is a connection...
                    if (checkWordConnection(newNode.getNodeString(), nextElement)) {

                        //If they are one letter apart..

                        //Create a temporary object to represent the identified node within the hash table
                        Node otherNode = nodeMap.get(nextElement);

                        //Create an edge between the two nodes
                        newNode.addLink(otherNode);
                        otherNode.addLink(newNode);

                    }
                }

            }

            //Add the new Node object to the hash table
            nodeMap.put(s, newNode);
        }

    }

    public boolean breadthFirstSearch(String word, String target) {

        //Create a new queue used for storing nodes that are still to be checked
        final Queue<Node> q = new LinkedList<Node>();

        //If the either the root, or target word cannot be located as a node within the graph..
        if (getNodeForWord(word) == null || getNodeForWord(target) == null) {

            //Terminate the search algorithm
            return false;
        }

        //Otherwise, retrieve the start word node from the graph
        Node root = getNodeForWord(word);

        //Add this node to the process queue
        q.add(root);

        //Set the 'isSearched' value to true to prevent the Node being checked again
        root.setHasBeenVisited(true);

        //While there are still Nodes to be checked
        while(! q.isEmpty()) {

            //Remove the next Node to be checked from the queue and set to local variable
            Node n = q.remove();

            //For every Node with an edge to the current Node
            for (Node child : n.getConnectedNodes()) {

                //If that Node has not already been checked..
                if (!child.hasBeenVisited()) {

                    //Prevent it being checked again for this search
                    child.setHasBeenVisited(true);

                    //Set the parent node of this Node to the Node that it is "child" of (i.e neighbour)
                    //Used to return the path (word ladder) once a search has completed
                    child.setParent(n);

                    //Add this Node to the process queue to allow its neighbours to be searched
                    q.add(child);

                }

            }
        }

        //Retrieve the Node representing the target node
        Node current = getNodeForWord(target);

        //Push this Node to the stack (word ladder)
        outputStack.push(current);

        //Until the start word node is reached
        while(! current.equals(getNodeForWord(word))) {

            //Retrieve the parent of the 'current' node
            current = current.getParent();

            //If one of the nodes does not have a parent
            //There is no word ladder available between the two words
            if (current == null) {

                //Therefore reset the node search variables
                reset();


                return false;
            }

            //Otherwise push the 'current' node to the output stack
            outputStack.push(current);
        }

        //Reset the node search variables
        reset();

        //Terminate the algorithm informing the GUI that a ladder was located
        return true;
    }

    public boolean checkWordConnection(String first, String second) {
        boolean areConnected = false;

        if (first.length() != second.length()) {

            // may throw exception, as we assume all words in collection must be same length...
            areConnected = false;


        } else {

            int differ = 0;

            // check characters one by one...
            for (int i = 0; i < first.length(); i++) {

                if (first.charAt(i) != second.charAt(i)) {

                    // different by one....
                    differ++;
                }
            }

            // if the words are only one letter different, they are connected...
            return (differ == 1);

        }

        return areConnected;
    }

    public Node getNodeForWord(String word) {
        return nodeMap.get(word);
    }
    
    // really just offered for testing purposes...
    public Hashtable<String, Node> getNodeMap() {
        return nodeMap;
        
    }

    public void reset() {
        Enumeration<String> e = nodeMap.keys();

        while (e.hasMoreElements()) {

            Node n = nodeMap.get(e.nextElement());

            //Reset the search variables
            n.setHasBeenVisited(false);
            n.setParent(null);
        }
    }
}
