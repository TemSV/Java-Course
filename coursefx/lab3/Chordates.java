package com.example.coursefx.lab3;

public abstract class Chordates {
    String name;
    String habitat;
    public Chordates(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public abstract void voice();

    @Override
    public String toString() {
        return (getClass().getSimpleName() + " " + name + " from " + habitat);
    }
}
