package com.example.coursefx.lab2;

import javafx.scene.control.TextArea;

public class TestClass {

    private final TextArea textArea;
    TestClass(TextArea textArea) {
        this.textArea = textArea;
    }

    @InvokeMethod(numberInvoking = 2)
    public void firstPublicMethod(int arg1) {
        textArea.appendText("firstPublicMethod that has arg " + arg1 + '\n');
    }

    public void secondPublicMethod() {
        textArea.appendText("secondPublicMethod\n");
    }

    public void thirdPublicMethod() {
        textArea.appendText("thirdPublicMethod\n");
    }

    @InvokeMethod(numberInvoking = 3)
    protected void firstProtectedMethod(int arg1, int arg2) {
        textArea.appendText("firstProtectedMethod that has args " + arg1 + " " + arg2 + '\n');
    }

    protected void secondProtectedMethod() {
        textArea.appendText("secondProtectedMethod\n");
    }

    protected void thirdProtectedMethod() {
        textArea.appendText("thirdProtectedMethod\n");
    }

    @InvokeMethod
    private void firstPrivateMethod(String str1, String str2) {
        textArea.appendText("FirstPrivateMethod that has args " + str1 + ' ' + str2 + '\n');
    }

    private void secondPrivateMethod(String str) {
        textArea.appendText("secondPrivateMethod that has arg " + str + '\n');
    }
}
