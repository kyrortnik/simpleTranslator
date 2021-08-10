package main.com.epam.service.impl;

import main.com.epam.data.TranslatorStorage;
import main.com.epam.data.impl.TranslatorStorageImp;
import main.com.epam.entity.WordPair;
import main.com.epam.exception.NoSuchValueException;
import main.com.epam.service.SimpleTranslator;

import java.util.ArrayList;

public class SimpleTranslatorImp implements SimpleTranslator {

    private final TranslatorStorage translatorStorage = new TranslatorStorageImp();


    @Override
    public void addWordPair(WordPair wordPair) {

        boolean englishDuplicateExists;
        boolean russianDuplicateExists;

        ArrayList<WordPair> dictionary = translatorStorage.getDictionary();
        ArrayList<WordPair> duplicates = new ArrayList<>();

        for (WordPair dictionaryPair : dictionary){
            englishDuplicateExists = wordPair.getEnglishWord().equals(dictionaryPair.getEnglishWord());
            russianDuplicateExists = wordPair.getRussianWord().equals(dictionaryPair.getRussianWord());
            if (englishDuplicateExists || russianDuplicateExists){
                duplicates.add(dictionaryPair);
            }
        }
        dictionary.removeAll(duplicates);
        dictionary.add(wordPair);

    }

    @Override
    public String findTranslation(String inputWord) throws NoSuchValueException {

         String translation = "";

        for (WordPair dictionaryPair : translatorStorage.getDictionary()){
            if (inputWord.equals(dictionaryPair.getEnglishWord())){
                translation = dictionaryPair.getRussianWord();
            }else if(inputWord.equals(dictionaryPair.getRussianWord())){
                translation = dictionaryPair.getEnglishWord();
            }
        }
        if (translation.equals("")){
            throw new NoSuchValueException("no such value");
        }
        return translation;

    }

    @Override
    public int getDictionarySize() {
        return translatorStorage.getDictionary().size();
    }

    @Override
    public String getAllDictionaryPairs() {
        return translatorStorage.toString();
    }


}
