package com.epam;

import com.epam.console.TranslatorConsoleApplication;
import com.epam.service.Quiz;
import com.epam.service.SimpleTranslator;
import com.epam.service.impl.QuizImpl;
import com.epam.service.impl.SimpleTranslatorImp;

public class Main {
    public static void main(String[] args)   {
       SimpleTranslator translator = new SimpleTranslatorImp();
       Quiz quiz = new QuizImpl();
       TranslatorConsoleApplication consoleApplication = new TranslatorConsoleApplication(translator,quiz);
       consoleApplication.start();
    }
}
