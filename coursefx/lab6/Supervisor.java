package com.example.coursefx.lab6;

import javafx.scene.control.TextArea;

public class Supervisor implements Runnable {

    private AbstractProgram abstractProgram;
    private Thread executableThread;

    private TextArea textArea;

    public Supervisor(AbstractProgram abstractProgram, TextArea textArea) {
        this.abstractProgram = abstractProgram;
        this.textArea = textArea;
        executableThread = new Thread(abstractProgram);
    }

    @Override
    public void run() {
        executableThread.start();
        synchronized (abstractProgram) {
            while (!Thread.interrupted() || executableThread.isInterrupted()) {
                try {
                    abstractProgram.wait();
                    reactToStateChange(abstractProgram.getState());
                    abstractProgram.notify();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    textArea.appendText("FATAL ERROR -> abstract program is finished\n");
                    break;
                }
            }
        }
    }

    private void reactToStateChange(ProgramState state) throws InterruptedException {
        switch (state) {
            case FATAL_ERROR -> {
                executableThread.interrupt();
                throw new InterruptedException();
            }
            case STOPPING -> restartProgram();
            default -> textArea.appendText("State of abstract program is " + state + "\n");
        }
    }

    void restartProgram() {
        textArea.appendText("State STOPPING -> restarting abstract program " +
                "<Counter value at the moment of restarting is " + abstractProgram.getCounter() + ">\n");
        abstractProgram.resetCounter();
    }
}
