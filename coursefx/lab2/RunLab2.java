package com.example.coursefx.lab2;

import javafx.scene.control.TextArea;

public class RunLab2 {

    public static void main(TextArea textArea)  {
        try {
            TestClass testClass = new TestClass(textArea);
            InvokeMethodHandler handler = new InvokeMethodHandler();
            handler.invokeAnnotatedMethods(testClass);
        }
        catch(Exception e) {
            textArea.appendText(e.getMessage());
        }
    }
}
