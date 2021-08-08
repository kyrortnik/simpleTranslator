package main.com.epam.console;

import main.com.epam.entity.WordPair;
import main.com.epam.exception.NoSuchValueException;
import main.com.epam.service.SimpleTranslator;

import java.io.Closeable;
import java.io.IOException;


public class TranslatorConsoleApplication {

    private final String WELCOME_MESSAGE = "Please enter number of operation you want to choose. Enter 0 to exit application." +
            "\n 1. Add words pair to dictionary." +
            "\n 2. Find translation for a word." +
            "\n 3. Show number of pairs in dictionary." +
            "\n 4. Show all words pairs.";

    private static final int EXIT = 0, ADD_WORDS_PAIR = 1, FIND_TRANSLATION = 2, SHOW_NUMBER_OF_PAIRS = 3, SHOW_ALL_PAIRS = 4;
    public static final String DELIMITER = "\n==============================================\n";

    private final SimpleTranslator translator;
    private final InputController inputController = new InputController();


    public TranslatorConsoleApplication(SimpleTranslator translator) {
        this.translator = translator;
    }

    public void start(){

        processMenu();
        inputController.cleanUpCloseables();

    }
    private void processMenu(){
        boolean isRunning = true;
        while (isRunning){
            printConsole(WELCOME_MESSAGE);
            printConsole(DELIMITER);
            int consoleChoice = inputController.getConsoleChoice();
            switch (consoleChoice){
                case EXIT:
                    isRunning = false;
                    printConsole("Exiting application");
                    break;
                case ADD_WORDS_PAIR:
                    addWordPairs();
                    break;
                case FIND_TRANSLATION:
                    showTranslation();
                    break;
                case SHOW_NUMBER_OF_PAIRS:
                    showNumberOfPairs();
                    break;
                case SHOW_ALL_PAIRS:
                    showAllPairs();
                    break;
                default:
                    printConsole("Invalid choice. Restarting app." + DELIMITER);
            }
        }

    }

    private void addWordPairs()  {
        final String english;
        final String russian;
        printConsole("Enter English word:");
        english = inputController.getWord();

        printConsole("Enter Russian word:");
        russian = inputController.getWord();

        WordPair wordPair = new WordPair(english,russian);
        translator.addWordPair(wordPair);


        printConsole("Word pair is added");
        printConsole(DELIMITER);
    }

    private void showTranslation()   {
        try {
            final String inputWord;
            printConsole("Enter your word:");
            inputWord = inputController.getWord();
              printConsole(translator.findTranslation(inputWord));
        }
        catch (NoSuchValueException e){
            System.out.println(e.getMessage());
        }
        printConsole(DELIMITER);

    }

    private void showNumberOfPairs(){
       printConsole("Number of word pairs is: "+ translator.getDictionarySize());
        printConsole(DELIMITER);

    }

    private void showAllPairs(){
        printConsole(translator.getAllDictionaryPairs());
        printConsole(DELIMITER);
    }


    private void printConsole(String message){
        System.out.println(message);
    }



}
