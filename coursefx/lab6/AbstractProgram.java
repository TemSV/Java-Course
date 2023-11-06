package com.example.coursefx.lab6;

import javafx.scene.control.TextArea;

import java.util.concurrent.ThreadLocalRandom;

public class AbstractProgram implements Runnable{

    private ProgramState state = ProgramState.UNKNOWN;

    private final TextArea textArea;

    AbstractProgram(TextArea textArea) {
        this.textArea = textArea;
    }

    private int counter = 0;

    @Override
    public void run() {
        var daemon = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    notify();
                    try {
                        wait();
                        Thread.sleep(2000);
                        int randomState = ThreadLocalRandom.current().nextInt(1, 4);
                        state = ProgramState.values()[randomState];
                        textArea.appendText("State = " + state + "\n");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        while (!Thread.currentThread().isInterrupted()) {
            doWork();
        }
    }

    void doWork() {
        counter++;
    }

    int getCounter() {
        return counter;
    }

    ProgramState getState() {
        return state;
    }

    void resetCounter() {
        counter = 0;
    }
}
