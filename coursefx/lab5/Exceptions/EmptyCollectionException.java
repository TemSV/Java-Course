package com.example.coursefx.lab5.Exceptions;

public class EmptyCollectionException extends Exception {
    public EmptyCollectionException() {
        super("Error! Collection is empty!");
    }
}
