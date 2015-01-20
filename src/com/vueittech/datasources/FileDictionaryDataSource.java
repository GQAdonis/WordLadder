package com.vueittech.datasources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by gqadonis on 1/19/15.
 */
public class FileDictionaryDataSource implements IDictionaryDataSource {
    private String fileName;
    private Vector<String> words = new Vector<String>();

    public FileDictionaryDataSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean initialize() {
        boolean initialized = false;

        try {

            FileReader fileReader;
            BufferedReader bufferedReader;

            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            // current line
            String line = null;


            // Load words line by line...
            while ((line = bufferedReader.readLine()) != null) {

                // add to vector
                words.add(line);

            }

            // close
            bufferedReader.close();

            initialized = true;

            // eat the exceptions...return false
        } catch (IOException iOE) {

            initialized = false;
        }

        return initialized;
    }

    @Override
    public Vector<String> getWords() {
        return words;
    }
}
