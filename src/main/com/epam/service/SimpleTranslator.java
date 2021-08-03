package main.com.epam.service;

import main.com.epam.doa.SimpleTranslatorDictionary;
import main.com.epam.entity.ParameterSet;

public interface SimpleTranslator {
    public void saveTranslation(ParameterSet parameterSet);
    public void findTranslation(ParameterSet parameterSet);
    public void getDictionarySize(SimpleTranslatorDictionary dictionary);
    public void getAllDictionaryPairs(SimpleTranslatorDictionary dictionary);


}
