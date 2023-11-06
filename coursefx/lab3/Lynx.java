package com.example.coursefx.lab3;

public class Lynx extends Cats {
    protected String habitat;
    protected int numberOfIndividuals;

    public Lynx(String name, String habitat) {
        super(name,habitat);
    }

    @Override
    public void voice() {
        System.out.println("Rrrrrr...I am lynx!");
    }
}
