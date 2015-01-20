package com.vueittech.datasources;

import static org.junit.Assert.*;

public class FileDictionaryDataSourceTest {
    
    private FileDictionaryDataSource fileDictionaryDataSource;
    private boolean initialized = false;

    @org.junit.Before
    public void setUp() throws Exception {

        fileDictionaryDataSource = new FileDictionaryDataSource("dict5.txt");
    }

    @org.junit.Test
    public void testInitialize() throws Exception {

        initialized = fileDictionaryDataSource.initialize();
        assertTrue(initialized);
    }

    @org.junit.Test
    public void testInitializeFailed() throws Exception {

        FileDictionaryDataSource testDataSource = new FileDictionaryDataSource("nothing.txt");
        
        initialized = testDataSource.initialize();
        assertFalse(initialized);
    }

    @org.junit.Test
    public void testGetWords() throws Exception {

        if (!initialized) {
            testInitialize();
        }
        
        System.out.println(fileDictionaryDataSource.getWords().size());
        assertTrue(fileDictionaryDataSource.getWords().size() > 0);
    }
}