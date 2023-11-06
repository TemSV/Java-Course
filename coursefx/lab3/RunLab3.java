package com.example.coursefx.lab3;

import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RunLab3 {
    public static void main(TextArea textArea) {
        List<Mammals> srcMammals = new ArrayList<>(6);

        srcMammals.add(new SimpleHedgehog("Alex", "Russia"));
        srcMammals.add(new SimpleHedgehog("John", "Europe"));
        srcMammals.add(new Manul("Bill", "Canada"));
        srcMammals.add(new Lynx("Sara", "USA"));
        srcMammals.add(new Lynx("Sam", "South Africa"));
        srcMammals.add(new Lynx("Bob", "South Africa"));

        List<Insectivorous> col1 = new ArrayList<>();
        List<Cats> col2 = new ArrayList<>();
        List<Predators> col3 = new ArrayList<>();

        segregate(srcMammals, col1, col2, col3);

        textArea.appendText(col1 + "\n");
        textArea.appendText(col2 + "\n");
        textArea.appendText(col3 + "\n");
        textArea.appendText("\n");

        List<Predators> srcPredators = new ArrayList<>(4);
        srcPredators.add(new Lynx("Lee", "Korea"));
        srcPredators.add(new Lynx("Boris", "Russia"));
        srcPredators.add(new Manul("Jack", "Canada"));
        srcPredators.add(new Manul("Bill", "USA"));

        List<Chordates> col12 = new ArrayList<>();
        List<Manul> col22 = new ArrayList<>();
        List<Cats> col32 = new ArrayList<>();

        segregate(srcPredators, col12, col22, col32);

        textArea.appendText(col12 + "\n");
        textArea.appendText(col22 + "\n");
        textArea.appendText(col32 + "\n");
        textArea.appendText("\n");

        List<Insectivorous> srcHedgehogs = new ArrayList<>(4);
        srcHedgehogs.add(new SimpleHedgehog("Gogi", "Georgia"));
        srcHedgehogs.add(new SimpleHedgehog("Ann", "Russia"));
        srcHedgehogs.add(new SimpleHedgehog("Lui", "Europe"));
        srcHedgehogs.add(new SimpleHedgehog("Jordan", "Europe"));

        List<Insectivorous> col13 = new ArrayList<>();
        List<Predators> col23 = new ArrayList<>();
        List<Predators> col33 = new ArrayList<>();

        segregate(srcHedgehogs, col13, col23, col33);
        textArea.appendText(col13 + "\n");
        textArea.appendText(col23 + "\n");
        textArea.appendText(col33 + "\n");
    }

    public static void segregate(Collection<? extends Mammals> srcCollection, Collection<? super SimpleHedgehog> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Lynx> collection3) {
        for (Mammals animal : srcCollection) {
            if (animal instanceof SimpleHedgehog) {
                collection1.add((SimpleHedgehog) animal);
            }
            else if (animal instanceof Manul) {
                collection2.add((Manul) animal);
            }
            else {
                collection3.add((Lynx) animal);
            }
        }
    }
}