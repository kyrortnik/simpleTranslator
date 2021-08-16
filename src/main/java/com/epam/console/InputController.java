package com.epam.console;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;

public class InputController {

    private final Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    private final Closeable[] closeables;

    public InputController() {
        this.closeables = new Closeable[]{scanner};
    }

    public int getConsoleChoice() {
        int choice;
        final int RESTART_VALUE = 777;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            cleanScannerNextEnteredValue();
            choice = RESTART_VALUE;
        }
        return choice;
    }

    public String getWord(){
        String word = "";
        if (scanner.hasNext()){
            word = scanner.next();
        }else {
            cleanScannerNextEnteredValue();
        }
        return word.toLowerCase(Locale.ROOT);

    }



    public ArrayList<String> getQuizAnswers(){
        ArrayList<String> answers = new ArrayList<>();
        int wordsNumber = 5;

            while (wordsNumber > 0) {
                answers.add(scanner.next().toLowerCase(Locale.ROOT));
                --wordsNumber;
            }
        return answers;

    }

    private void cleanScannerNextEnteredValue() {
        final String next = scanner.next();
        System.out.println("Entered [" + next +" ]" );
    }

    public void cleanUpCloseables() {
        for (final Closeable closeable : closeables) {
            try {
                closeable.close();

            } catch (final IOException e) {
                System.out.println("Something went wrong during closing " + closeable.getClass());
                e.printStackTrace();
            }
        }
    }


}
