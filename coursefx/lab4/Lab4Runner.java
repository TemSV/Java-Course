package com.example.coursefx.lab4;

import com.example.coursefx.lab4.exceptions.FileReadException;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Lab4Runner {

    public static String readFile(String path, Charset encoding) throws FileReadException {
        try {
            return Files.readString(Paths.get(path), encoding);
        } catch (IOException e) {
            throw new FileReadException(e.getMessage());
        }
    }

    public static void main(File dictionaryFile, File textFile, TextArea textArea) {
        try {
            Dictionary d = new Dictionary(dictionaryFile);
            String text = readFile(textFile.toString(), StandardCharsets.UTF_8);

            Translator translator = new Translator(dictionaryFile);
            textArea.appendText(translator.translate(text));
        } catch (Exception e) {
            textArea.appendText(e.getMessage());
        }
    }
}