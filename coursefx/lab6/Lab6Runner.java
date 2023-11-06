package com.example.coursefx.lab6;

import javafx.scene.control.TextArea;

public class Lab6Runner {
    public static void main(TextArea textArea) {
        AbstractProgram abstractProgram = new AbstractProgram(textArea);
        Supervisor supervisor = new Supervisor(abstractProgram, textArea);
        new Thread(supervisor).start();
    }
}