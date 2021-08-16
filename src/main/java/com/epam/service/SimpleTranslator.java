package com.epam.service;

import com.epam.entity.WordPair;
import com.epam.exception.NoSuchValueException;

public interface SimpleTranslator {

    void addWordPair(WordPair wordPair);
    String findTranslation(String word) throws NoSuchValueException;
    int getDictionarySize();
    String getAllDictionaryPairs();

}
