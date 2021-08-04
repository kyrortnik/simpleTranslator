package main.com.epam.doa;

import main.com.epam.entity.ParameterSet;

import java.util.ArrayList;

public class SimpleTranslatorDictionary {
    private ArrayList<ParameterSet> dictionary = new ArrayList<>();


    {
        dictionary.add(new ParameterSet("русский","russian"));
        dictionary.add(new ParameterSet("английский","english"));
        dictionary.add(new ParameterSet("дом","house"));
        dictionary.add(new ParameterSet("река","river"));
        dictionary.add(new ParameterSet("озеро","lake"));
        dictionary.add(new ParameterSet("гора","mountain"));
        dictionary.add(new ParameterSet("машина","car"));
        dictionary.add(new ParameterSet("семья","family"));
        dictionary.add(new ParameterSet("парень","guy"));
        dictionary.add(new ParameterSet("девушка","girl"));


    }

}

