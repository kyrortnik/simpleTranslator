package main.com.epam.data.impl;

import main.com.epam.data.TranslatorStorage;
import main.com.epam.entity.WordPair;

import java.util.ArrayList;

public class TranslatorStorageImp implements TranslatorStorage {

    private final ArrayList<WordPair> dictionary = new ArrayList<>();

    {
        dictionary.add(new WordPair("russian","русский"));
        dictionary.add(new WordPair("english","английский"));
        dictionary.add(new WordPair("house","дом"));
        dictionary.add(new WordPair("river","река"));
        dictionary.add(new WordPair("lake","озеро"));
        dictionary.add(new WordPair("mountain","гора"));
        dictionary.add(new WordPair("car","машина"));
        dictionary.add(new WordPair("family","семья"));
        dictionary.add(new WordPair("guy","парень"));
        dictionary.add(new WordPair("girl","девушка"));

    }

    public ArrayList<WordPair> getDictionary() {
        return dictionary;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (WordPair wordPair: dictionary){
            builder.append(wordPair.getEnglishWord()).append(" - ").append(wordPair.getRussianWord()).append("\n");
        }
        return builder.toString().trim();

    }
}

