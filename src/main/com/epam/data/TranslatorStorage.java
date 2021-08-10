package main.com.epam.data;

import main.com.epam.entity.WordPair;

import java.util.ArrayList;

public interface TranslatorStorage {
    ArrayList<WordPair> getDictionary();
}
