package com.vueittech;

import com.vueittech.datasources.FileDictionaryDataSource;
import com.vueittech.datasources.IDictionaryDataSource;
import com.vueittech.datastructures.Graph;
import com.vueittech.datastructures.Node;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        if (args.length < 3) {
            System.out.println("Must provide 3 arguments: your word, your target, and your dictionary file!");
            return;
        }

        IDictionaryDataSource dictionaryDataSource = new FileDictionaryDataSource(args[2]);
        if (dictionaryDataSource.initialize()) {
            Graph graph = new Graph(dictionaryDataSource.getWords());
            if (graph.breadthFirstSearch(args[0], args[1])) {
                Iterator<Node> nodeIterator =  graph.getOutputStack().iterator();

                while (nodeIterator.hasNext()) {
                    Node node = nodeIterator.next();
                    System.out.println(node.getNodeString());
                }
            } else {
                System.out.println("There is no valid path between these two words!");
            }


        } else {
            System.out.println("Initialization of dictionary data source failed.");
        }

    }
}
