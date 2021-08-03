package main.com.epam;

import main.com.epam.console.TranslatorConsoleApplication;
import main.com.epam.service.SimpleTranslator;
import main.com.epam.service.impl.SimpleTranslatorImp;

public class Main {
    public static void main(String[] args) {
        SimpleTranslator translator = new SimpleTranslatorImp();
        TranslatorConsoleApplication consoleApplication = new TranslatorConsoleApplication();
        consoleApplication.start();
    }
}
