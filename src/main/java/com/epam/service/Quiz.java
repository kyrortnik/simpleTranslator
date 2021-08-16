package com.epam.service;

import com.epam.entity.WordPair;

import java.util.ArrayList;

public interface Quiz {

    ArrayList<WordPair> getRandomPairs();
    void getQuizWordsFromRandomPairs(ArrayList<WordPair> randomPairs);
    double getRightAnswersPercentage(ArrayList<WordPair> randomPairs, ArrayList<String> answers);
    ArrayList<WordPair> getRightVariants(ArrayList<WordPair> randomPairs, ArrayList<String> answers);
    void showRightVariants(ArrayList<WordPair> rightVariants);
}
