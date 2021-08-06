package main.com.epam.console;

import java.util.Scanner;

public class InputController {

    private final Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    public InputController() {
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
        return word;

    }

    private void cleanScannerNextEnteredValue() {
        final String next = scanner.next();
        System.out.println("Entered [" + next +" ]" );
    }




}
