package com.epam.data;

import com.epam.entity.WordPair;

import java.util.ArrayList;

public interface TranslatorStorage {
    ArrayList<WordPair> getDictionary();
}
