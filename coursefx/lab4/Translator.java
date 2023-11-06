package com.example.coursefx.lab4;

import com.example.coursefx.lab4.exceptions.FileReadException;
import com.example.coursefx.lab4.exceptions.InvalidFileFormatException;

import java.io.File;
import java.util.Arrays;

public class Translator {

    private Dictionary dictionary;

    public Translator(File file) {
        setDictionary(file);
    }

    String translate(String text) {
        StringBuilder translatedText = new StringBuilder();
        StringBuilder untranslatedText = new StringBuilder(text);
        while (!untranslatedText.isEmpty()) {
            StringBuilder tmp = new StringBuilder(untranslatedText.toString().trim());
            while (!untranslatedText.isEmpty()) {
                tmp = new StringBuilder(tmp.toString().trim());
                untranslatedText = new StringBuilder(untranslatedText.toString().trim());
                if (dictionary.hasWord(tmp.toString().toLowerCase())) {
                    translatedText.append(dictionary.getTranslation(tmp.toString().toLowerCase())).append(" ");
                    untranslatedText = new StringBuilder(untranslatedText.substring(tmp.length()));
                    break;
                }
                String [] tmpArr = tmp.toString().split(" ");
                if (tmpArr.length != 1) {
                    tmpArr = Arrays.copyOf(tmpArr, tmpArr.length - 1);
                    tmp = new StringBuilder();
                    for (String value : tmpArr) {
                        tmp.append(value).append(" ");
                    }
                    tmp = new StringBuilder(tmp.substring(0,tmp.length()));
                }
                else {
                    translatedText.append(tmpArr[0]).append(' ');
                    tmp = new StringBuilder(tmpArr[0]);
                    untranslatedText = new StringBuilder(untranslatedText.substring(tmp.length()));
                    tmp = new StringBuilder(untranslatedText);
                }
            }
        }
        return translatedText.toString();
    }

    private void setDictionary(File file) {
        try {
            dictionary = new Dictionary(file);
        }
        catch (FileReadException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
            dictionary = null;
        }
    }
}
