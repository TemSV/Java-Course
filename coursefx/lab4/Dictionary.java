package com.example.coursefx.lab4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.coursefx.lab4.exceptions.FileReadException;
import com.example.coursefx.lab4.exceptions.InvalidFileFormatException;


public class Dictionary {
    private final Map<String, String> dictionary;

    public Dictionary(File file) throws FileReadException, InvalidFileFormatException {
        this.dictionary = readDictionary(file);
    }

    private Map<String, String> readDictionary(File file) throws FileReadException, InvalidFileFormatException {
        Map<String, String> dictionary = new HashMap<>();
        try(FileReader fileReader = new FileReader(file)) {
            Scanner in = new Scanner(fileReader);
            while(in.hasNextLine()) {
                String line = in.nextLine();
                String [] words = line.split("\\|");
                if (words.length != 2) {
                    throw new InvalidFileFormatException();
                }
                dictionary.put(words[0].trim().toLowerCase(), words[1].trim().toLowerCase());
            }
        }
        catch(IOException e) {
            throw new FileReadException(e.getMessage());
        }
        return dictionary;
    }

    public boolean hasWord(String word) {
        return dictionary.containsKey(word);
    }

    public String getTranslation(String word) {
        return dictionary.get(word);
    }

    public void printDictionary() {
        dictionary.forEach((key, value) -> System.out.println(key + " | " + value));
    }
}
