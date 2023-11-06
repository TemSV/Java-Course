package com.example.coursefx.lab3;

public class Manul extends Cats {

    public Manul(String name, String habitat) {
        super(name,habitat);
    }

    @Override
    public void voice() {
        System.out.println("Rrrrrr...I am manul!");
    }
}
