package com.example.coursefx.lab5;

import com.example.coursefx.lab5.Exceptions.EmptyCollectionException;
import javafx.scene.control.TextArea;

import java.util.*;

public class Lab5Runner {

    public static void main(TextArea textArea) {
        List<Integer> list1 = List.of(4, 5, 6);
        textArea.appendText("Average of " + list1 + " is " + StreamMethods.getAverageValue(list1) + "\n");
        List<String> listStr = List.of("some", "list", "of", "strings");
        textArea.appendText("Transformed " + listStr + " is " + StreamMethods.transformStrings(listStr) + "\n");
        List<Double> list2 = List.of(3.0, 3.0, 5.0, 7.0);
        textArea.appendText("Unique squares of " + list2 + " are " + StreamMethods.getUniqueSquares(list2) + "\n");
        textArea.appendText("Words starting with letter s in " + listStr + " are " + StreamMethods.getStringsStartingWithLetter(listStr, 's') + "\n");
        try {
            List<Integer> emptyList = List.of();
            textArea.appendText("Last elem in collection " + listStr + " is " + StreamMethods.getLastElement(listStr) + "\n");
            textArea.appendText("Last elem in collection " + emptyList + " is " + StreamMethods.getLastElement(emptyList) + "\n");
        } catch (EmptyCollectionException e) {
            textArea.appendText(e.getMessage() + "\n");
        }

        int [] arr1 = {1, 3, 5, 6, 10};
        textArea.appendText("Sum of evens in " + Arrays.toString(arr1) + " is " + StreamMethods.getSumOFEvens(arr1) + "\n");
        textArea.appendText("List " + listStr + " to map " + StreamMethods.convertListToMap(listStr) + "\n");
    }
}
