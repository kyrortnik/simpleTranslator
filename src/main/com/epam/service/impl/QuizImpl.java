package main.com.epam.service.impl;

import main.com.epam.data.TranslatorStorage;
import main.com.epam.entity.WordPair;
import main.com.epam.service.Quiz;

import java.util.ArrayList;
import java.util.Random;

public class QuizImpl implements Quiz {

    private final TranslatorStorage translatorStorage = new TranslatorStorage();

    @Override
    public ArrayList<WordPair> getRandomPairs() {

        Random random = new Random();
        ArrayList<WordPair> temporaryDictionary = new ArrayList<>(translatorStorage.getDictionary());
        ArrayList<WordPair> randomlyPickedPairs = new ArrayList<>();
        int numberOfRandomValues = 5;

        for (int i =0; i<numberOfRandomValues;i++){
            int randomIndex = random.nextInt(temporaryDictionary.size());
            randomlyPickedPairs.add(temporaryDictionary.get(randomIndex));
            temporaryDictionary.remove(randomIndex);
        }

        return randomlyPickedPairs;
    }

    @Override
    public void getQuizWordsFromRandomPairs(ArrayList<WordPair> randomPairs){
        StringBuilder builder = new StringBuilder();
        for (WordPair pair : randomPairs){
            builder.append(pair.getEnglishWord()).append(" ");
        }
        System.out.println(builder);
    }

    @Override
    public double getRightAnswersPercentage(ArrayList<WordPair> randomPairs, ArrayList<String> answers) {
        double numberOfRightAnswers = 0;

        for (int i = 0;i<answers.size();i++){
            if ((randomPairs.get(i).getRussianWord()).equals(answers.get(i))){
                numberOfRightAnswers++;
            }
        }
        return  (numberOfRightAnswers / randomPairs.size()) * 100;
    }

    @Override
    public ArrayList<WordPair> getRightVariants(ArrayList<WordPair> randomPairs, ArrayList<String> answers) {
        ArrayList<WordPair> correctedAnswers = new ArrayList<>();
        for (int i = 0;i<answers.size();i++){
            if (!(randomPairs.get(i).getRussianWord()).equals(answers.get(i))){
                correctedAnswers.add(randomPairs.get(i));
            }
        }

        return correctedAnswers;
    }

    @Override
    public void showRightVariants(ArrayList<WordPair> rightVariants){
        if (rightVariants.size() != 0){
            System.out.println("Here are variants which were not correct:");
            for (WordPair wordPair : rightVariants){
                System.out.println(wordPair.getEnglishWord() + " - " + wordPair.getRussianWord());
            }
        }
    }
}
