package main.com.epam.service;

import main.com.epam.entity.WordPair;
import main.com.epam.exception.NoSuchValueException;

public interface SimpleTranslator {

    void addWordPair(WordPair wordPair);
    String findTranslation(String word) throws NoSuchValueException;
    int getDictionarySize();
    String getAllDictionaryPairs();

}
