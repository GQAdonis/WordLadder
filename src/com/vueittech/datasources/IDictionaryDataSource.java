package com.vueittech.datasources;

import java.util.Vector;

/**
 * Created by gqadonis on 1/19/15.
 */
public interface IDictionaryDataSource {
    boolean initialize();
    Vector<String> getWords();
}
